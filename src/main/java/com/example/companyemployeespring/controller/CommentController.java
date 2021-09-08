package com.example.companyemployeespring.controller;

import com.example.companyemployeespring.entity.Comment;
import com.example.companyemployeespring.entity.Employee;
import com.example.companyemployeespring.entity.Message;
import com.example.companyemployeespring.entity.Topic;
import com.example.companyemployeespring.security.CurrentUser;
import com.example.companyemployeespring.service.CommentService;
import com.example.companyemployeespring.service.MessageService;
import com.example.companyemployeespring.service.TopicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CommentController {

    private final CommentService commentService;
    private final TopicService topicService;

    @GetMapping("/comments")
    public String comments(ModelMap modelMap, @RequestParam int id, @AuthenticationPrincipal CurrentUser currentUser) {

        Topic topic = topicService.getTopic(id);
        List<Comment> comments = commentService.findByTopic_Id(id);
        modelMap.addAttribute("comments", comments);
        modelMap.addAttribute("topic", topic);
        log.info("User with {} username opened comments page", currentUser.getEmployee().getEmail());
        return "comments";
    }


    @PostMapping("/comments")

    public String addComment(@RequestParam(name = "text") String text, @RequestParam(name = "topic") Topic topic, @AuthenticationPrincipal CurrentUser currentUser) {
        Comment comment = new Comment();
        comment.setEmployee(currentUser.getEmployee());
        comment.setCreatedDate(LocalDate.now());
        comment.setName(text);
        comment.setTopic(topic);
        commentService.saveComment(comment);
        log.info("User with {} username added comments", currentUser.getEmployee().getEmail());
        return "redirect:/comments?id=" + topic.getId();
    }




    @GetMapping("/deleteComment")
    public String deleteComment(@RequestParam int id, @AuthenticationPrincipal CurrentUser currentUser) {
        commentService.deleteComment(id);
        log.info("User with {} username delete comments", currentUser.getEmployee().getEmail());
        return "redirect:/comments";
    }
}
