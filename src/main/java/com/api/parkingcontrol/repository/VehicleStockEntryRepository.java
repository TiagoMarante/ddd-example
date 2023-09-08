package com.api.parkingcontrol.repository;


import com.api.parkingcontrol.models.VehicleStockEntry.VehicleStockEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleStockEntryRepository extends JpaRepository<VehicleStockEntry, Long> {

    boolean existsByVin(String vin);

    // Custom method to find all entries where isUsed is "yes"
    List<VehicleStockEntry> findByIsUsed(String isUsed);

    @Query("SELECT vse FROM VehicleStockEntry vse WHERE vse.isUsed = 'yes'")
    List<VehicleStockEntry> findAllUsedEntries();


}
