package com.project.springboot.internship_tracking.repository;

import com.project.springboot.internship_tracking.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer,Integer> {
}
