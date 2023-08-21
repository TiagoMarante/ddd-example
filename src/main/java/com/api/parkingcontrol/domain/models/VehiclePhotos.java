package com.api.parkingcontrol.domain.models;


import javax.persistence.*;

@Entity
@Table(name = "VEHICLE_PHOTOS")
public class VehiclePhotos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = false, length = 500)
    private String url;

    @Column(nullable = false, unique = false)
    private int priority;

    @ManyToOne
    @JoinColumn(name = "vehicle_stock_entry_id")
    private VehicleStockEntry vehicleStockEntry;

}
