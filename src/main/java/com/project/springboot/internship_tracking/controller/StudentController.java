package com.project.springboot.internship_tracking.controller;

import com.project.springboot.internship_tracking.model.Company;
import com.project.springboot.internship_tracking.model.Lecturer;
import com.project.springboot.internship_tracking.model.Student;
import com.project.springboot.internship_tracking.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor

public class StudentController {
    private final StudentService studentService;



    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), OK); //static-import for HTTP Status OK 200
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
        return new ResponseEntity<>(findStudentById(id),OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student newStudent){
        return new ResponseEntity<>(studentService.createStudent(newStudent),CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable int id, @RequestBody Student newStudent){
        studentService.updateStudent(id,newStudent);
        return new ResponseEntity<>(OK);
    }

    @PutMapping("/{id}/lecturers/{lecturer_id}")
    public String addLecturerToStudent(@PathVariable int id, @PathVariable int lecturer_id){
        Student student=findStudentById(id); //it is local method to non-repeat myself
        return studentService.addLecturerToStudent(student,lecturer_id);
    }

    @PutMapping("/{student_id}/company/{company_id}")
    public String addCompanyToStudent(@PathVariable int student_id, @PathVariable int company_id){
        Student student=findStudentById(student_id);
        return studentService.addCompanyToStudent(student,company_id);
    }

    @GetMapping("/{student_id}/lecturer")
    public Lecturer getMyLecturer(@PathVariable int student_id){
        Student student= findStudentById(student_id); //it is local method to non-repeat myself
        return studentService.getMyLecturer(student);
    }

    @GetMapping("/{student_id}/company")
    public Company getMyCompany(@PathVariable int student_id){
        Student student= findStudentById(student_id); //it is local method to non-repeat myself
        return studentService.getMyCompany(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
       studentService.deleteStudent(id);
       return new ResponseEntity<>(OK);
    }

    private Student findStudentById(int id){
        return studentService.getStudentById(id);
    }
}
