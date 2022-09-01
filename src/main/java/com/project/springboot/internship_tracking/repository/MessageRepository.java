package com.project.springboot.internship_tracking.repository;

import com.project.springboot.internship_tracking.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Integer> {
}
