package com.example.companyemployeespring.service.impl;

import com.example.companyemployeespring.entity.Message;
import com.example.companyemployeespring.repository.MessageRepository;
import com.example.companyemployeespring.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public List<Message> findAllMessages() {
        return messageRepository.findAll();
    }



    @Override
    public List<Message> findMyMessages(int toId, int fromId) {
        return messageRepository.findByFromIdAndToIdOrToIdAndFromId(toId, fromId);
    }

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public void deleteMessage(int id) {
        messageRepository.deleteById(id);
    }
}
