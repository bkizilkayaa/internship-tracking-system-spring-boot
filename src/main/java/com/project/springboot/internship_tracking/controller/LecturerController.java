package com.project.springboot.internship_tracking.controller;

import com.project.springboot.internship_tracking.model.Lecturer;
import com.project.springboot.internship_tracking.model.Message;
import com.project.springboot.internship_tracking.model.Student;
import com.project.springboot.internship_tracking.service.LecturerService;
import com.project.springboot.internship_tracking.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/lecturers")
@RequiredArgsConstructor
public class LecturerController {
    private final LecturerService lecturerService;
    private final MessageService messageService;

    @GetMapping
    public ResponseEntity<List<Lecturer>> getLecturers(){
        return new ResponseEntity<>(lecturerService.getLecturers(), OK);
    }
    @PutMapping("/{id}/messages/{message_id}")
    public String addMessagesToLecturer(@PathVariable int id, @PathVariable int message_id){
        Lecturer lecturer = lecturerService.getLecturerById(id);
        Message message=messageService.getMessageById(message_id);
        lecturer.setMessageList(lecturer.getMessageList());
        return lecturerService.updateLecturer(id,lecturer);
    }

}
