package com.community.demo.controller;

import com.community.demo.Model.User;
import com.community.demo.dto.NotificationDTO;
import com.community.demo.enums.NotificationTypeEnum;
import com.community.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NotificationController {
    @Autowired
    NotificationService notificationService;
    @GetMapping("/notification/{id}")
    public String profile(HttpServletRequest request, @PathVariable(name = "id") Integer id) {
        User user =(User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        NotificationDTO notificationDTO = notificationService.read(id, user);
        if(NotificationTypeEnum.REPLY_COMMENT.getType()==notificationDTO.getType()
            || NotificationTypeEnum.REPLY_QUESTION.getType()==notificationDTO.getType()) {
            return "redirect:/question/" + notificationDTO.getOuterId();
        }
        else{
            return "redirect:/";
        }
    }
}
