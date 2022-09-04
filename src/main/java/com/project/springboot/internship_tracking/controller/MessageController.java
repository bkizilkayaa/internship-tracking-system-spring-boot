package com.project.springboot.internship_tracking.controller;


import com.project.springboot.internship_tracking.model.Message;
import com.project.springboot.internship_tracking.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor

public class MessageController {
    private final MessageService messageService;

    @GetMapping
    public ResponseEntity<List<Message>> getMessages(){
        return new ResponseEntity<>(messageService.getMessages(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessagesById(@PathVariable int id){
        return new ResponseEntity<>(messageService.getMessageById(id),OK);
    }

    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message newMessage){
        return new ResponseEntity<>(messageService.createMessage(newMessage),OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMessage(@PathVariable int id, @RequestBody Message newMessage){
        messageService.updateMessage(id,newMessage);
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable int id){
        messageService.deleteMessage(id);
    }
}
