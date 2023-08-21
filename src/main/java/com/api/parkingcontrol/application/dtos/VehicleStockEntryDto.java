package com.api.parkingcontrol.application.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class VehicleStockEntryDto {
    @NotBlank
    private String parkingSpotNumber;

    @NotBlank
    @Size(max = 20)
    private String licensePlateCar;

    @NotBlank
    @Size(max = 70)
    private String type;

    @NotBlank
    private int id_card;

    @NotBlank
    @Size(max = 200)
    private String condition;

    @NotBlank
    @Size(max = 200)
    private String description;


    @NotBlank
    @Size(max = 200)
    private String statusDescription;

}
