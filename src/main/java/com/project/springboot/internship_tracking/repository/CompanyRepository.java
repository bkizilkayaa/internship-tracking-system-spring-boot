package com.project.springboot.internship_tracking.repository;

import com.project.springboot.internship_tracking.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
