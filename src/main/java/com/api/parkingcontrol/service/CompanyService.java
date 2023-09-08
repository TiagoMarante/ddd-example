package com.api.parkingcontrol.service;

import com.api.parkingcontrol.dto.creation.CreateCompanyDto;
import com.api.parkingcontrol.dto.responses.ResponseCompanyDto;
import com.api.parkingcontrol.exceptions.CompanyException;
import com.api.parkingcontrol.models.Company.Company;
import com.api.parkingcontrol.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyService {

    final CompanyRepository companyRepository;

    public ResponseCompanyDto saveCompany(CreateCompanyDto createCompanyDto) {
        var company = new Company();

        BeanUtils.copyProperties(createCompanyDto, company);


        return mapToResponse(companyRepository.save(company));
    }

    public List<ResponseCompanyDto> findAll() {
        var allEntries = companyRepository.findAll();
        return allEntries.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public ResponseCompanyDto findById(long id) {
        var stockEntry = companyRepository.findById(id).orElseThrow(CompanyException::companyNotFound);
        return mapToResponse(stockEntry);
    }


    private ResponseCompanyDto mapToResponse(Company company) {
        var companyDto = new ResponseCompanyDto();
        BeanUtils.copyProperties(company, companyDto);
        return companyDto;
    }
}
