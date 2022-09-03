package com.project.springboot.internship_tracking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MessageNotFoundById extends RuntimeException {
    public MessageNotFoundById(String msg) {
        super(msg);
    }
}
