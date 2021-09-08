package com.example.companyemployeespring.service.impl;

import com.example.companyemployeespring.entity.Topic;
import com.example.companyemployeespring.repository.TopicRepository;
import com.example.companyemployeespring.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;


    @Override
    public Topic getTopic(int id) {
        return topicRepository.getById(id);
    }

    @Override
    public List<Topic> findByEmployee_Company_Id(int companyId) {
        List<Topic> topics = topicRepository.findByEmployee_Company_Id(companyId);
        return topics;
    }

    @Override
    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public void deleteTopic(int id) {
        topicRepository.deleteById(id);
    }


}
