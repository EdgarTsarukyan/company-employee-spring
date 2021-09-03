package com.example.companyemployeespring.repository;


import com.example.companyemployeespring.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {


    @Query("from Message sms where (sms.from.id =:fromId and sms.to.id=:toId) or ( sms.from.id=:toId and sms.to.id=:fromId) ")
    List<Message> findByFromIdAndToIdOrToIdAndFromId(@Param("fromId") int fromId, @Param("toId") int toId);
}
