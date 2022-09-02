package com.project.springboot.internship_tracking.controller;

import com.project.springboot.internship_tracking.model.Company;
import com.project.springboot.internship_tracking.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/companies")
public class CompanyController {
    public final CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies(), OK);
    }

    @GetMapping("/{company_id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable int company_id){
        return new ResponseEntity<>(companyService.getCompanyById(company_id),OK);
    }

    @PostMapping
    public ResponseEntity<Company> addCompany(@RequestBody Company newCompany){
        return new ResponseEntity<>(companyService.addCompany(newCompany),OK);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<Void> updateCompany(@PathVariable int companyId,@RequestBody Company newCompany){
        companyService.updateCompany(companyId,newCompany);
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> deleteCompany(@PathVariable int companyId){
        companyService.deleteCompany(companyId);
        return new ResponseEntity<>(OK);
    }
}
