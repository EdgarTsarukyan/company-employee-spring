package com.example.companyemployeespring.service;

import com.example.companyemployeespring.entity.Comment;
import com.example.companyemployeespring.entity.Message;
import com.example.companyemployeespring.entity.Topic;

import java.util.List;

public interface CommentService {


    List<Comment> findByTopic_Id(int Id);



    void saveComment(Comment comment);

    void deleteComment(int id);
}
