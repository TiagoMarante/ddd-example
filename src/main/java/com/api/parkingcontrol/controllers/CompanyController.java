package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dto.creation.CreateCompanyDto;
import com.api.parkingcontrol.dto.responses.ResponseCompanyDto;
import com.api.parkingcontrol.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyController {

    final CompanyService companyService;

    @PostMapping
    public ResponseEntity<ResponseCompanyDto> createCompany(@RequestBody @Valid CreateCompanyDto createCompanyDto){
        return new ResponseEntity<>(companyService.saveCompany(createCompanyDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseCompanyDto>> getAllCompanies(){
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }

}
