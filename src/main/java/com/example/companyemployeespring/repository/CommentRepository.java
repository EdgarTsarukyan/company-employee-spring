package com.example.companyemployeespring.repository;


import com.example.companyemployeespring.entity.Comment;
import com.example.companyemployeespring.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {


   List<Comment> findByTopic_Id(int Id);
}
