package com.api.parkingcontrol.service;

import com.api.parkingcontrol.dto.creation.CreateVehicleStockEntryDto;
import com.api.parkingcontrol.dto.responses.ResponseVehicleStockEntry;
import com.api.parkingcontrol.models.VehicleStockEntry.VehicleStatus;
import com.api.parkingcontrol.models.VehicleStockEntry.VehicleStockEntry;
import com.api.parkingcontrol.repository.VehicleStockEntryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleStockEntryService {

    final VehicleStockEntryRepository vehicleStockEntryRepository;

    public boolean existsByVin(String vin) {
        System.out.println(vehicleStockEntryRepository.existsByVin(vin));
        return vehicleStockEntryRepository.existsByVin(vin);
    }

    public ResponseVehicleStockEntry saveVehicleStockEntry(CreateVehicleStockEntryDto createVehicleStockEntryDto) {
        var vehicleStockEntry = new VehicleStockEntry();
        BeanUtils.copyProperties(createVehicleStockEntryDto, vehicleStockEntry);

        var vehicleStatus = new VehicleStatus(createVehicleStockEntryDto.getStatusDescription());
        vehicleStockEntry.setVehicleStatus(vehicleStatus);

        return mapToResponse(vehicleStockEntryRepository.save(vehicleStockEntry));
    }

    public List<ResponseVehicleStockEntry> findAll(Pageable pageable) {
        var allEntries = vehicleStockEntryRepository.findAll();
        System.out.println(allEntries);
        return allEntries.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public VehicleStockEntry findById(long id) {
        var stockEntry = vehicleStockEntryRepository.findById(id);
        return stockEntry.get();
    }


    private ResponseVehicleStockEntry mapToResponse(VehicleStockEntry vehicleStockEntry) {
        var reviewDto = new ResponseVehicleStockEntry();
        BeanUtils.copyProperties(vehicleStockEntry, reviewDto);

        return reviewDto;
    }
}
