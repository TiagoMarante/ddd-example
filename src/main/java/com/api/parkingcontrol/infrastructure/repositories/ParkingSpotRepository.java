package com.api.parkingcontrol.infrastructure.repositories;

import com.api.parkingcontrol.domain.models.ParkingSpotModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {

    boolean existsByLicensePlateCar(String licensePlateCar);
    boolean existsByParkingSpotNumber(String parkingSpotNumber);
    boolean existsByApartmentAndBlock(String apartment, String block);
    List<ParkingSpotModel> findParkingSpotModelByBrandCar(String brandCar);
}
