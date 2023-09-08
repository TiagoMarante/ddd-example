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
public class CreateVehiclePhotosDto {
    @Min(1)
    private long id;

    @NotBlank
    @Size(max = 500)
    private String url;

    @Min(1)
    private int priority;

}
