package com.api.parkingcontrol.dto.creation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class CreateCompanyDto {

    @NotBlank
    @Size(max = 500)
    private String description;

    @NotBlank
    @Size(max = 500)
    private String country;

    @NotBlank
    @Size(max = 500)
    private String currency;

    @NotBlank
    @Size(max = 500)
    private String status;

}
