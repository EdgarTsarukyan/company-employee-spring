package com.example.companyemployeespring.service;

import com.example.companyemployeespring.entity.Message;

import java.util.List;

public interface MessageService {


    List<Message> findAllMessages();

    List<Message> findMyMessages(int toId, int fromId);

    void saveMessage(Message message);

    void deleteMessage(int id);
}
