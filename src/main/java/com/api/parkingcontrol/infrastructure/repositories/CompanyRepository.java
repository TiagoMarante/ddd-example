package com.api.parkingcontrol.infrastructure.repositories;

import com.api.parkingcontrol.domain.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
