package com.api.parkingcontrol.init.repository;

import com.api.parkingcontrol.init.models.VehiclePhotos.VehiclePhotos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiclePhotosRepository extends JpaRepository<VehiclePhotos, Long> {
    List<VehiclePhotos> findByVehicleStockEntry_Id(long id);
}
