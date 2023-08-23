package com.api.parkingcontrol.repository;


import com.api.parkingcontrol.models.VehiclePhotos.VehiclePhotos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiclePhotosRepository extends JpaRepository<VehiclePhotos, Long> {
    List<VehiclePhotos> findByVehicleStockEntry_Id(long id);
}
