package com.project.springboot.internship_tracking.service;

import com.project.springboot.internship_tracking.exception.MessageNotFoundById;
import com.project.springboot.internship_tracking.model.Lecturer;
import com.project.springboot.internship_tracking.model.Message;
import com.project.springboot.internship_tracking.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository; //constructor injection.
    private final LecturerService lecturerService;

    public MessageService(MessageRepository messageRepository, LecturerService lecturerService) {
        this.messageRepository = messageRepository;
        this.lecturerService = lecturerService;
    }

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

    public String addMessageToLecturer(int lecturer_id, int message_id) {
        try {
            Lecturer lecturer = lecturerService.getLecturerById(lecturer_id);
            Message message = getMessageById(message_id);
            if (message.getLecturerMessage() == null) {
                message.setLecturerMessage(new Lecturer());
            }
            message.setLecturerMessage(lecturer);
            messageRepository.save(message);
            return "message successfully added to lecturer";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void deleteMessage(int id) {
        messageRepository.delete(getMessageById(id));
    }
}
