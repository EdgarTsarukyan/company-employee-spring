package com.example.companyemployeespring.controller;

import com.example.companyemployeespring.entity.Employee;
import com.example.companyemployeespring.entity.Topic;
import com.example.companyemployeespring.security.CurrentUser;
import com.example.companyemployeespring.service.TopicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TopicController {

private final TopicService topicService;

    @GetMapping("/topics")
    public String topic(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<Topic> topics = topicService.findByEmployee_Company_Id(currentUser.getEmployee().getCompany().getId());
        modelMap.addAttribute("topics", topics);
        log.info("User with {} username open topics page, topics.size = {}", currentUser.getEmployee().getEmail(),topics.size());
        return "topics";

    }
    @PostMapping("/addTopic")
    public String addTopicPost( @AuthenticationPrincipal CurrentUser currentUser, @RequestParam String text ) {
        Topic topic = new Topic();
        topic.setText(text);
        topic.setEmployee(currentUser.getEmployee());
        topic.setCreatedDate(LocalDate.now());

        topicService.addTopic(topic);
        log.info("User with {} username added topic", currentUser.getEmployee().getEmail());
        return "redirect:/topics";
    }
    @GetMapping("/addTopic")
    public String addTopic(@AuthenticationPrincipal CurrentUser currentUser) {
        log.info("User with {} username opened addTopic page", currentUser.getEmployee().getEmail());
        return "addTopic";
    }

    @GetMapping("/deleteTopic")
    public String deleteTopic(@RequestParam int id, @AuthenticationPrincipal CurrentUser currentUser) {
        topicService.deleteTopic(id);
        log.info("User with {} username delete topic", currentUser.getEmployee().getEmail());
        return "redirect:/topics";
    }


}