package com.project.springboot.internship_tracking.controller;

import com.project.springboot.internship_tracking.model.Lecturer;
import com.project.springboot.internship_tracking.model.Student;
import com.project.springboot.internship_tracking.service.LecturerService;
import com.project.springboot.internship_tracking.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor

public class StudentController {
    private final StudentService studentService;
    private final LecturerService lecturerService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), OK); //static-import for HTTP Status OK 200
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
        return new ResponseEntity<>(studentService.getStudentById(id),OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student newStudent){
        return new ResponseEntity<>(studentService.createStudent(newStudent),CREATED);
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student newStudent){
        return studentService.updateStudent(id,newStudent);
    }

    @PutMapping("/{id}/lecturer/{lecturer_id}")
    public String addLecturerToStudent(@PathVariable int id, @PathVariable int lecturer_id){
        Student student = studentService.getStudentById(id);
        Lecturer lecturer=lecturerService.getLecturerById(lecturer_id);
        student.setLecturer(lecturer);
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
       studentService.deleteStudent(id);
       return new ResponseEntity<>(OK);
    }
}
