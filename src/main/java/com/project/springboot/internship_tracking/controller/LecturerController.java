package com.project.springboot.internship_tracking.controller;

import com.project.springboot.internship_tracking.model.Lecturer;
import com.project.springboot.internship_tracking.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/lecturers")
@RequiredArgsConstructor
public class LecturerController {
    private final LecturerService lecturerService;

    @GetMapping()
    public ResponseEntity<List<Lecturer>> getLecturers(){
        return new ResponseEntity<>(lecturerService.getLecturers(), OK);
    }

}
