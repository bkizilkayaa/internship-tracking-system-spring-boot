package com.project.springboot.internship_tracking.controller;

import com.project.springboot.internship_tracking.model.Lecturer;
import com.project.springboot.internship_tracking.model.Message;
import com.project.springboot.internship_tracking.model.Student;
import com.project.springboot.internship_tracking.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/lecturers")
@RequiredArgsConstructor
public class LecturerController {
    private final LecturerService lecturerService;
//    private final MessageService messageService;

    @GetMapping
    public ResponseEntity<List<Lecturer>> getLecturers(){
        return new ResponseEntity<>(lecturerService.getLecturers(), OK);
    }
    @GetMapping("/{lecturer_id}")
    public ResponseEntity<Lecturer> getLecturerById(@PathVariable int lecturer_id){
        return new ResponseEntity<>(lecturerService.getLecturerById(lecturer_id),OK);
    }
    @GetMapping("/{lecturer_id}/studentlist")
    public ResponseEntity<List<Student>> getMyStudents(@PathVariable int lecturer_id){
        return new ResponseEntity<>(lecturerService.getMyStudentList(lecturer_id),OK);
    }
    @PostMapping
    public ResponseEntity<Lecturer> addLecturer(@RequestBody Lecturer newLecturer){
        return new ResponseEntity<>(lecturerService.addLecturer(newLecturer),CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateLecturer(@PathVariable int id,@RequestBody Lecturer newLecturer){
        lecturerService.updateLecturer(id,newLecturer);
        return new ResponseEntity<>(OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
        lecturerService.deleteLecturer(id);
        return new ResponseEntity<>(OK);
    }

    @GetMapping("/{lecturer_id}/messages/{message_id}")
    public String getLecturerMessageById(@PathVariable int lecturer_id,@PathVariable int message_id){
        //Lecturer lecturer=lecturerService.getLecturerById(lecturer_id);
        //Message message=messageService.getMessageById(message_id);
        return lecturerService.getMyMessage(lecturer_id,message_id);
    }

    @GetMapping("/{lecturer_id}/messages")
    public List<Message> getLecturerMessages(@PathVariable int lecturer_id){
        return lecturerService.getMyMessageList(lecturer_id);
    }



}
