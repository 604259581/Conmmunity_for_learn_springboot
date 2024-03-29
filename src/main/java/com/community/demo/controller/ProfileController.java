package com.community.demo.controller;

import com.community.demo.Mapper.UserMapper;
import com.community.demo.Model.User;
import com.community.demo.dto.NotificationDTO;
import com.community.demo.dto.PageDTO;
import com.community.demo.service.ListService;
import com.community.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    private ListService listService;
    @Autowired
    private NotificationService notifacationService;
    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action, Model model,
                          HttpServletRequest request, @RequestParam(name = "page", defaultValue = "1") int page,
                          @RequestParam(name = "size", defaultValue = "5") int size) {
        Cookie[] cookies = request.getCookies();
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }

        if ("questions".equals(action)) {  //这样做是为了防止action为空指针调用action.equal()出错。
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
            PageDTO pageDTO = listService.List(user.getId(), page, size);
            model.addAttribute("pageDTO", pageDTO);
        }
        if ("replies".equals(action)) {
            PageDTO pageDTO = notifacationService.List(user.getId(), page, size);
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
            model.addAttribute("pageDTO", pageDTO);
        }

        return "profile";
    }
}
