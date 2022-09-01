package com.project.springboot.internship_tracking.exception;

public class LecturerNotFoundById extends RuntimeException {
    public LecturerNotFoundById(String msg) {
        super(msg);
    }
}
