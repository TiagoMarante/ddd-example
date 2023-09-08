package com.api.parkingcontrol.dto.creation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class CreateVehicleStockEntryDto {
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
