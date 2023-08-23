package com.api.parkingcontrol.models.VehicleStockProvider;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE_STOCK_PROVIDER")
public class VehicleStockProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = false, length = 200)
    private String description;

    @Column(nullable = false, unique = false, length = 200)
    private String ws_address;
}
