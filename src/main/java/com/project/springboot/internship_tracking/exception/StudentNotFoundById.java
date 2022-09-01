package com.project.springboot.internship_tracking.exception;

public class StudentNotFoundById extends RuntimeException {
    public StudentNotFoundById(String msg) {
        super(msg);
    }
}
