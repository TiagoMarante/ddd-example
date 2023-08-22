package com.api.parkingcontrol.init.models.VehicleStockEntry;

import com.api.parkingcontrol.init.models.Company.Company;
import com.api.parkingcontrol.init.models.VehiclePhotos.VehiclePhotos;
import com.api.parkingcontrol.init.models.VehicleStockProvider.VehicleStockProvider;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "VEHICLE_STOCK_ENTRY")
public class VehicleStockEntry implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true, length = 20)
    private String vin;

    @Column(nullable = false, length = 70)
    private String type;

    @Column(nullable = false, unique = true)
    private int id_cardb;

    @Column(nullable = false, unique = false, length = 200)
    private String isUsed;

    @Column(nullable = false, unique = false, length = 200)
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_Stock_Provider_id")
    private VehicleStockProvider vehicleStockProvider;

    @Embedded
    private VehicleStatus vehicleStatus;

    @OneToMany(mappedBy = "vehicleStockEntry", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VehiclePhotos> vehiclePhotos = new ArrayList<>();

    @JsonManagedReference
    public List<VehiclePhotos> getVehiclePhotos() {
        return vehiclePhotos;
    }
}
