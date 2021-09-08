package com.example.companyemployeespring.repository;


import com.example.companyemployeespring.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

    List<Topic> findByEmployee_Company_Id(int companyId);

}
