package com.project.springboot.internship_tracking.service;

import com.project.springboot.internship_tracking.exception.LecturerNotFoundById;
import com.project.springboot.internship_tracking.exception.MessageNotFoundById;
import com.project.springboot.internship_tracking.model.Message;
import com.project.springboot.internship_tracking.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(int message_id) {
        return messageRepository.findById(message_id)
                .orElseThrow(() -> new MessageNotFoundById("Message not found by id : " + message_id));
    }

    public Message createMessage(Message newMessage) {
        return messageRepository.save(newMessage);
    }

    public void updateMessage(int id, Message newMessage) {
        try{
            Message oldMessage= getMessageById(id);
            oldMessage.setText(newMessage.getText());
            oldMessage.setTitle(newMessage.getTitle());
            oldMessage.setCreateDate(new Date());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void deleteMessage(int id) {
        messageRepository.delete(getMessageById(id));
    }
}
