package com.project.springboot.internship_tracking.exception;

public class CompanyNotFoundById extends RuntimeException {
    public CompanyNotFoundById(String msg) {
        super(msg);
    }
}
