package com.example.companyemployeespring.service;

import com.example.companyemployeespring.entity.Topic;

import java.util.List;

public interface TopicService {
    Topic getTopic(int id);

    List<Topic> findByEmployee_Company_Id(int companyId);

    void addTopic(Topic topic);

    void deleteTopic(int id);
}
