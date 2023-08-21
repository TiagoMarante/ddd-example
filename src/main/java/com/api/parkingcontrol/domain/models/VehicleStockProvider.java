package com.api.parkingcontrol.domain.models;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE_STOCK_PROVIDER")
public class VehicleStockProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = false, length = 200)
    private String description;

    @Column(nullable = false, unique = false, length = 200)
    private String ws_address;
}
