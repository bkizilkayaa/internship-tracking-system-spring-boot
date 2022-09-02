package com.project.springboot.internship_tracking.service;


import com.project.springboot.internship_tracking.exception.StudentNotFoundById;
import com.project.springboot.internship_tracking.model.Lecturer;
import com.project.springboot.internship_tracking.model.Student;
import com.project.springboot.internship_tracking.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final LecturerService lecturerService;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) { //custom exception handler yazacagim
        return studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFoundById("Student not found by id : "+id));
    }

    public Student createStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    public String updateStudent(int id, Student newStudent) {
        try{
            Student oldStudent=getStudentById(id);
            oldStudent.setName(newStudent.getName());
            oldStudent.setSurname(newStudent.getSurname());
            oldStudent.setCompanyId(newStudent.getCompanyId());
            oldStudent.set_lecturer(newStudent.get_lecturer());
            return "student successfully updated!";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    public void deleteStudent(int id) {
        studentRepository.delete(getStudentById(id));
    }

    public Lecturer getMyLecturer(Student student) {
        return lecturerService.getLecturerById(student.get_lecturer().getId());
    }
}
