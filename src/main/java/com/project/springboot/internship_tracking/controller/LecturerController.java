package com.project.springboot.internship_tracking.controller;

import com.project.springboot.internship_tracking.model.Lecturer;
import com.project.springboot.internship_tracking.model.Message;

import com.project.springboot.internship_tracking.service.LecturerService;
import com.project.springboot.internship_tracking.service.MessageService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
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
    @PostMapping
    public ResponseEntity<Lecturer> addLecturer(@RequestBody Lecturer newLecturer){
        return new ResponseEntity<>(lecturerService.addLecturer(newLecturer),CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateLecturer(@PathVariable int lecturer_id,@RequestBody Lecturer newLecturer){
        lecturerService.updateLecturer(lecturer_id,newLecturer);
        return new ResponseEntity<>(OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
        lecturerService.deleteLecturer(id);
        return new ResponseEntity<>(OK);
    }
    @PutMapping("/{id}/messages/{message_id}")
    public String addMessagesToLecturer(@PathVariable int id, @PathVariable int message_id){
        Lecturer lecturer = lecturerService.getLecturerById(id);
        Message message=messageService.getMessageById(message_id);
        lecturer.messageList.add(message);
        return lecturerService.updateLecturer(id,lecturer);
    }

    @GetMapping("/{lecturer_id}/messages/{message_id}")
    public String getLecturerMessageById(@PathVariable int lecturer_id,@PathVariable int message_id){
        Lecturer lecturer=lecturerService.getLecturerById(lecturer_id);
        Message message=messageService.getMessageById(message_id);
        return lecturerService.getMyMessage(lecturer,message);
    }



}
