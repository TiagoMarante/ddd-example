package com.api.parkingcontrol.service;

import com.api.parkingcontrol.dto.creation.CreateVehiclePhotosDto;
import com.api.parkingcontrol.dto.responses.ResponseVehiclePhotos;
import com.api.parkingcontrol.exceptions.VehiclePhotosException;
import com.api.parkingcontrol.models.VehiclePhotos.VehiclePhotos;
import com.api.parkingcontrol.repository.VehiclePhotosRepository;
import com.api.parkingcontrol.repository.VehicleStockEntryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehiclePhotosService {

    final VehiclePhotosRepository vehiclePhotosRepository;

    final VehicleStockEntryRepository vehicleStockEntryRepository;

    public ResponseVehiclePhotos saveVehiclePhotos(CreateVehiclePhotosDto createVehiclePhotosDto) {
        var vehiclePhotos = new VehiclePhotos();
        BeanUtils.copyProperties(createVehiclePhotosDto, vehiclePhotos);

        var vehicleStockEntry = vehicleStockEntryRepository.findById(createVehiclePhotosDto.getId()).orElseThrow(() ->
                new VehiclePhotosException("Entry stock not Found !!!"));

        vehiclePhotos.setVehicleStockEntry(vehicleStockEntry);

        vehiclePhotosRepository.save(vehiclePhotos);

        return mapToResponse(vehiclePhotos);
    }


    public List<ResponseVehiclePhotos> findAll() {
        var allPhotos = vehiclePhotosRepository.findAll();
        return allPhotos.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public List<ResponseVehiclePhotos> findPhotosByStockEntryId(long id) {
        var vehiclePhoto = vehiclePhotosRepository.findByVehicleStockEntry_Id(id);
        return vehiclePhoto.stream().map(this::mapToResponse).collect(Collectors.toList());
    }



    private ResponseVehiclePhotos mapToResponse (VehiclePhotos vehiclePhotos){
        var vehiclePhotosResponse = new ResponseVehiclePhotos();
        BeanUtils.copyProperties(vehiclePhotosResponse, vehiclePhotos);

        return vehiclePhotosResponse;
    }
}
