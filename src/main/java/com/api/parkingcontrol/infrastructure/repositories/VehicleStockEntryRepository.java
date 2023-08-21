package com.api.parkingcontrol.infrastructure.repositories;

import com.api.parkingcontrol.domain.models.VehicleStockEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleStockEntryRepository extends JpaRepository<VehicleStockEntry, Integer> {

}
