package com.project.springboot.internship_tracking.service;

import com.project.springboot.internship_tracking.exception.CompanyNotFoundById;
import com.project.springboot.internship_tracking.model.Company;
import com.project.springboot.internship_tracking.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CompanyService {


    private final CompanyRepository companyRepository; //uses constructor injection not field injection.
                                                      //i mean not Autowired!
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(int company_id) {
        return companyRepository.findById(company_id)
                .orElseThrow(()-> new CompanyNotFoundById("company not found by id : "+company_id));
    }

    public Company addCompany(Company newCompany) {
        return companyRepository.save(newCompany);
    }
    public void updateCompany(int companyId, Company newCompany) {
        Company _oldCompany=getCompanyById(companyId);

        _oldCompany.setCompanyName(newCompany.getCompanyName());

        companyRepository.save(_oldCompany);
    }
    public void deleteCompany(int companyId) {
        companyRepository.deleteById(companyId);
    }

}
