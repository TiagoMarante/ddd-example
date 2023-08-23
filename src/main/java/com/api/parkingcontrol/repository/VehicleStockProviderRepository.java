package com.api.parkingcontrol.repository;

import com.api.parkingcontrol.models.VehicleStockEntry.VehicleStockEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleStockProviderRepository extends JpaRepository<VehicleStockEntry, Long> {

}
