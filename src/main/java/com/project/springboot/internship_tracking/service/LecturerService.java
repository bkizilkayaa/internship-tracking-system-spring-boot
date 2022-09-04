package com.project.springboot.internship_tracking.service;


import com.project.springboot.internship_tracking.exception.LecturerNotFoundById;
import com.project.springboot.internship_tracking.model.Lecturer;
import com.project.springboot.internship_tracking.model.Message;
import com.project.springboot.internship_tracking.model.Student;
import com.project.springboot.internship_tracking.repository.LecturerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LecturerService {
        private final LecturerRepository lecturerRepository; //constructor injection.

    public LecturerService(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    public List<Lecturer> getLecturers() {
        return lecturerRepository.findAll();
    }

    public Lecturer getLecturerById(int lecturer_id) {
        return lecturerRepository.findById(lecturer_id)
                .orElseThrow(()-> new LecturerNotFoundById("Lecturer not found by id : "+lecturer_id));
    }

    public Lecturer updateLecturer(int id, Lecturer newLecturer) {
            Lecturer oldLecturer=getLecturerById(id);
            oldLecturer.setName(newLecturer.getName());
            oldLecturer.setEmail(newLecturer.getEmail());
            return lecturerRepository.save(oldLecturer);
    }

    public String getMyMessage(Lecturer lecturer, Message message) {
        if(lecturer.getId().equals(message.getLecturerMessage().getId())){
            return message.getText();
        }
        else{
            return "this person doesn't have that data you want.";
        }
    }

    public Lecturer addLecturer(Lecturer newLecturer) {
        return lecturerRepository.save(newLecturer);
    }

    public void deleteLecturer(int id) {
        lecturerRepository.delete(getLecturerById(id));
    }

    public List<Student> getMyStudentList(int lecturer_id) {
        return (lecturerRepository.findById(lecturer_id).get()).getStudentList();
    }

   /* public void addStudentToLecturer(Student student, int lecturer_id) {
        Lecturer lecturer=lecturerRepository.findById(lecturer_id)
                .orElseThrow(()->new LecturerNotFoundById("lecturer not found by id "+lecturer_id));

        List<Student> studentList= lecturer.getStudentList();
        studentList.add(student);
        lecturer.setStudentList(studentList);
    }*/
}
