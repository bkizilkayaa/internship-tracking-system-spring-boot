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

    public void updateLecturer(int id, Lecturer newLecturer) {
            Lecturer oldLecturer=getLecturerById(id);
            oldLecturer.setName(newLecturer.getName());
            oldLecturer.setEmail(newLecturer.getEmail());
            lecturerRepository.save(oldLecturer);
    }




    public String getMyMessage(int lecturer_id,int message_id) { //?
         Lecturer lecturer = lecturerRepository.findById(lecturer_id)
                 .orElseThrow(()->new LecturerNotFoundById("lecturer not found by id : "+lecturer_id));

        for (var a:lecturer.getMessageList()) {
                if(a.getId()==message_id) {
                    return a.getText();
                }
        }
            return "lecturer doesn't have message like that.";
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

    public List<Message> getMyMessageList(int lecturer_id) {
        Lecturer lecturer=lecturerRepository.findById(lecturer_id)
                .orElseThrow(()->new LecturerNotFoundById("lecturer not found by id : "+lecturer_id));
        return lecturer.getMessageList();

    }
}
