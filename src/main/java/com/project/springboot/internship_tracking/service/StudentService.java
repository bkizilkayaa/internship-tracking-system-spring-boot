package com.project.springboot.internship_tracking.service;


import com.project.springboot.internship_tracking.exception.StudentNotFoundById;
import com.project.springboot.internship_tracking.model.Company;
import com.project.springboot.internship_tracking.model.Lecturer;
import com.project.springboot.internship_tracking.model.Student;
import com.project.springboot.internship_tracking.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository; //constructor injection.
    private final LecturerService lecturerService;  //constructor injection.

    private final CompanyService companyService; //const. injection

    public StudentService(StudentRepository studentRepository, LecturerService lecturerService, CompanyService companyService) {
        this.studentRepository = studentRepository;
        this.lecturerService = lecturerService;
        this.companyService = companyService;
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

    public void updateStudent(int id, Student newStudent) {
        try{
            Student oldStudent=getStudentById(id);
            oldStudent.setName(newStudent.getName());
            oldStudent.setSurname(newStudent.getSurname());
            studentRepository.save(oldStudent);
        }
        catch (Exception e){
            System.out.println("an error occurred "+e.getMessage());
        }

    }
    public String addLecturerToStudent(Student student, int lecturer_id) {
           Lecturer lecturer=lecturerService.getLecturerById(lecturer_id);
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

    public String addCompanyToStudent(Student student, int company_id) {
        Company company= companyService.getCompanyById(company_id);
        if(student.getStudent_company_list() == null){
            student.setStudent_company_list(new Company());
        }
        student.setStudent_company_list(company);
        studentRepository.save(student);
        return "student successfully updated!";
    }

    public Company getMyCompany(Student student) {
        return companyService.getCompanyById(student.getId());
    }
}
