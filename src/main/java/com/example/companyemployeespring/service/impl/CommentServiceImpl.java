package com.example.companyemployeespring.service.impl;

import com.example.companyemployeespring.entity.Comment;
import com.example.companyemployeespring.entity.Message;
import com.example.companyemployeespring.entity.Topic;
import com.example.companyemployeespring.repository.CommentRepository;
import com.example.companyemployeespring.repository.MessageRepository;
import com.example.companyemployeespring.service.CommentService;
import com.example.companyemployeespring.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;


    @Override
    public List<Comment> findByTopic_Id(int id) {
        return commentRepository.findByTopic_Id(id);
    }



    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }
}
