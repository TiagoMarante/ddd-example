package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dto.creation.CreateVehiclePhotosDto;
import com.api.parkingcontrol.dto.responses.ResponseVehiclePhotos;
import com.api.parkingcontrol.service.VehiclePhotosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vehicle-photos")
@AllArgsConstructor
public class VehiclePhotosController {

    final VehiclePhotosService vehiclePhotosService;

    @PostMapping
    public ResponseEntity<ResponseVehiclePhotos> createVehiclePhotos(@RequestBody @Valid CreateVehiclePhotosDto createVehiclePhotosDto){
        return new ResponseEntity<>(vehiclePhotosService.saveVehiclePhotos(createVehiclePhotosDto), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<ResponseVehiclePhotos>> getAllParkingSpots(){
        return ResponseEntity.status(HttpStatus.OK).body(vehiclePhotosService.findAll());
    }

}
