package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dto.creation.CreateVehicleStockEntryDto;
import com.api.parkingcontrol.dto.responses.ResponseVehicleStockEntry;
import com.api.parkingcontrol.service.VehicleStockEntryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vehicle-stock-entry")
@AllArgsConstructor
public class VehicleStockEntryController {

    final VehicleStockEntryService vehicleStockEntryService;

    @PostMapping
    public ResponseEntity<ResponseVehicleStockEntry> createVehicleStockEntry(@RequestBody @Valid CreateVehicleStockEntryDto createVehicleStockEntryDto){
        return new ResponseEntity<>(vehicleStockEntryService.saveVehicleStockEntry(createVehicleStockEntryDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseVehicleStockEntry>> getAllParkingSpots(){
        return new ResponseEntity<>(vehicleStockEntryService.findAll(), HttpStatus.OK);

    }

}
