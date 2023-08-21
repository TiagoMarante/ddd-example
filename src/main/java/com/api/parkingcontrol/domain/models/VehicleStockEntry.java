package com.api.parkingcontrol.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "VEHICLE_STOCK_ENTRY")
public class VehicleStockEntry implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true, length = 20)
    private String vin;

    @Column(nullable = false, length = 70)
    private String type;

    @Column(nullable = false, unique = true)
    private int id_cardb;

    @Column(nullable = false, unique = false, length = 200, name = "`condition`")
    private String condition;

    @Column(nullable = false, unique = false, length = 200)
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicleStockProvider_id")
    private VehicleStockProvider vehicleStockProvider;

    @Embedded
    private VehicleStatus vehicleStatus;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleStockEntry")
    private List<VehiclePhotos> vehiclePhotos;


}
