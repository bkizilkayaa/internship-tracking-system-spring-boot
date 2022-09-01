package com.project.springboot.internship_tracking.repository;

import com.project.springboot.internship_tracking.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
