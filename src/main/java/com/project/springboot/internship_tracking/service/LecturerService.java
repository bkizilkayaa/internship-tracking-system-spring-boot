package com.project.springboot.internship_tracking.service;


import com.project.springboot.internship_tracking.exception.LecturerNotFoundById;
import com.project.springboot.internship_tracking.model.Lecturer;
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
}
