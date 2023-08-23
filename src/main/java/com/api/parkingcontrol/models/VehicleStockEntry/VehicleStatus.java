package com.api.parkingcontrol.models.VehicleStockEntry;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class VehicleStatus {

    @Column(nullable = false, unique = false, length = 200)
    private String statusDescription;
}
