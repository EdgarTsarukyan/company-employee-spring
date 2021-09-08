package com.example.companyemployeespring.controller;

import com.example.companyemployeespring.entity.Employee;
import com.example.companyemployeespring.entity.Message;
import com.example.companyemployeespring.security.CurrentUser;
import com.example.companyemployeespring.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/messages")
    public String employees(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {

        List<Message> all = messageService.findAllMessages();
        modelMap.addAttribute("messages", all);
        log.info("User with {} username opened messages page, employee.size = {}", currentUser.getEmployee().getEmail(), all.size());
        return "messages";
    }


    @PostMapping("/sendMessage")

    public String addMessage(@RequestParam(name = "message") String text, @RequestParam(name = "toId") Employee toId, @AuthenticationPrincipal CurrentUser currentUser) {
        Message message = new Message();
        message.setText(text);
        message.setFrom(currentUser.getEmployee());
        message.setTo(toId);
        messageService.saveMessage(message);
        log.info("User with {} username send message", currentUser.getEmployee().getEmail());
        return "redirect:/sendMessage?id=" + toId.getId();
    }

    @GetMapping("/sendMessage")

    public String sendMessage(@RequestParam Employee id, ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        List<Message> myMessages = messageService.findMyMessages(id.getId(), currentUser.getEmployee().getId());
        modelMap.addAttribute("myMessages", myMessages);
        modelMap.addAttribute("toId", id);
        log.info("User with {} username opened sendMessage page", currentUser.getEmployee().getEmail());
        return "sendMessage";
    }


    @GetMapping("/deleteMessage")
    public String deleteMessage(@RequestParam int id, @AuthenticationPrincipal CurrentUser currentUser) {
        messageService.deleteMessage(id);
        log.info("User with {} username delete message", currentUser.getEmployee().getEmail());
        return "redirect:/messages";
    }
}
