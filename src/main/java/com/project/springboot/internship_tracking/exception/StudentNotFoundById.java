package com.project.springboot.internship_tracking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundById extends RuntimeException {
    public StudentNotFoundById(String msg) {
        super(msg);
    }
}
