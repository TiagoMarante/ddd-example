package com.api.parkingcontrol.init.models.VehiclePhotos;


import com.api.parkingcontrol.init.models.VehicleStockEntry.VehicleStockEntry;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "VEHICLE_PHOTOS")
public class VehiclePhotos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = false, length = 500)
    private String url;

    @Column(nullable = false, unique = false)
    private int priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_Stock_Entry_id")
    private VehicleStockEntry vehicleStockEntry;

    @JsonBackReference
    public VehicleStockEntry getVehicleStockEntry() {
        return vehicleStockEntry;
    }
}
