package com.api.parkingcontrol.init.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class VehicleStockEntryDto {
    @NotBlank
    private String vin;

    @NotBlank
    @Size(max = 70)
    private String type;

    @Min(1)
    private int id_cardb;

    @NotBlank
    @Size(max = 200)
    private String isUsed;

    @NotBlank
    @Size(max = 200)
    private String description;


    @NotBlank
    @Size(max = 200)
    private String statusDescription;

}
