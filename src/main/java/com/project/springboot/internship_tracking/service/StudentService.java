package com.project.springboot.internship_tracking.service;


import com.project.springboot.internship_tracking.exception.StudentNotFoundById;
import com.project.springboot.internship_tracking.model.Lecturer;
import com.project.springboot.internship_tracking.model.Student;
import com.project.springboot.internship_tracking.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository; //constructor injection.
    private final LecturerService lecturerService;  //constructor injection.

    public StudentService(StudentRepository studentRepository, LecturerService lecturerService) {
        this.studentRepository = studentRepository;
        this.lecturerService = lecturerService;
    }

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

    public Student updateStudent(int id, Student newStudent) {
            Student oldStudent=getStudentById(id);
            oldStudent.setName(newStudent.getName());
            oldStudent.setSurname(newStudent.getSurname());
            oldStudent.setCompanyId(newStudent.getCompanyId());
            return studentRepository.save(oldStudent);
    }
    public String addLecturerToStudent(Student student, Lecturer lecturer) {
            if(student.get_lecturer() == null){
                student.set_lecturer(new Lecturer());
            }
            student.set_lecturer(lecturer);
            studentRepository.save(student);
            return "student successfully updated!";
    }

    public void deleteStudent(int id) {
        studentRepository.delete(getStudentById(id));
    }

    public Lecturer getMyLecturer(Student student) {
        return lecturerService.getLecturerById(student.get_lecturer().getId());
    }
}
