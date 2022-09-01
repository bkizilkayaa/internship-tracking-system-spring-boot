package com.project.springboot.internship_tracking.exception;

public class MessageNotFoundById extends RuntimeException {
    public MessageNotFoundById(String msg) {
        super(msg);
    }
}
