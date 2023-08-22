package com.api.parkingcontrol.init.controllers;

import com.api.parkingcontrol.init.dto.ResponseVehiclePhotos;
import com.api.parkingcontrol.init.dto.VehiclePhotosDto;
import com.api.parkingcontrol.init.service.VehiclePhotosService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<ResponseVehiclePhotos> createVehiclePhotos(@RequestBody @Valid VehiclePhotosDto vehiclePhotosDto){
        return new ResponseEntity<>(vehiclePhotosService.saveVehiclePhotos(vehiclePhotosDto), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<ResponseVehiclePhotos>> getAllParkingSpots(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(vehiclePhotosService.findAll(pageable));
    }

}
