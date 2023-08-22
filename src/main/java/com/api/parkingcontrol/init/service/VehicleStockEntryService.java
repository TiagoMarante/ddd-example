package com.api.parkingcontrol.init.service;

import com.api.parkingcontrol.init.dto.ResponseVehicleStockEntry;
import com.api.parkingcontrol.init.dto.VehicleStockEntryDto;
import com.api.parkingcontrol.init.models.VehicleStockEntry.VehicleStatus;
import com.api.parkingcontrol.init.models.VehicleStockEntry.VehicleStockEntry;
import com.api.parkingcontrol.init.repository.VehicleStockEntryRepository;
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

    public ResponseVehicleStockEntry saveVehicleStockEntry(VehicleStockEntryDto vehicleStockEntryDto) {
        var vehicleStockEntry = new VehicleStockEntry();
        BeanUtils.copyProperties(vehicleStockEntryDto, vehicleStockEntry);

        var vehicleStatus = new VehicleStatus(vehicleStockEntryDto.getStatusDescription());
        vehicleStockEntry.setVehicleStatus(vehicleStatus);

        return mapToResponse(vehicleStockEntryRepository.save(vehicleStockEntry));
    }

    public List<ResponseVehicleStockEntry> findAll(Pageable pageable) {
        System.out.println("entrei sem problemas");
        var allEntries = vehicleStockEntryRepository.findAll();
        System.out.println(allEntries);
        return allEntries.stream().map(this::mapToResponse).collect(Collectors.toList());
    }


    private ResponseVehicleStockEntry mapToResponse(VehicleStockEntry vehicleStockEntry) {
        var reviewDto = new ResponseVehicleStockEntry();
        BeanUtils.copyProperties(vehicleStockEntry, reviewDto);

        return reviewDto;
    }
}
