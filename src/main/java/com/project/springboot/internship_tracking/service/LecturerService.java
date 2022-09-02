package com.project.springboot.internship_tracking.service;


import com.project.springboot.internship_tracking.exception.LecturerNotFoundById;
import com.project.springboot.internship_tracking.model.Lecturer;
import com.project.springboot.internship_tracking.model.Message;

import com.project.springboot.internship_tracking.repository.LecturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LecturerService {
    private final LecturerRepository lecturerRepository;
    public List<Lecturer> getLecturers() {
        return lecturerRepository.findAll();
    }

    public Lecturer getLecturerById(int lecturer_id) {
        return lecturerRepository.findById(lecturer_id)
                .orElseThrow(()-> new LecturerNotFoundById("Lecturer not found by id : "+lecturer_id));
    }

    public String updateLecturer(int id, Lecturer newLecturer) {
        try{
            Lecturer oldLecturer=getLecturerById(id);
            oldLecturer.setName(newLecturer.getName());
            oldLecturer.setMessageList(newLecturer.getMessageList());
            oldLecturer.setEmail(newLecturer.getEmail());
            oldLecturer.setStudentList(newLecturer.getStudentList());
            return "lecturer successfully updated!";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    public String getMyMessage(Lecturer lecturer, Message message) {
        if(lecturer.getId()==message.getLecturerMessage().getId()){
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
}
