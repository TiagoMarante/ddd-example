package com.api.parkingcontrol.init.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseVehicleStockEntry {
    private String vin;
    private String type;
    private int id_cardb;
    private String isUsed;
    private String description;
    private String statusDescription;

}
