package com.community.demo.controller;


import com.community.demo.Mapper.UserMapper;
import com.community.demo.Model.User;
import com.community.demo.dto.PageDTO;
import com.community.demo.dto.QuestionDTO;
import com.community.demo.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ListService listService;
    @GetMapping("/")
    public String index2(HttpServletRequest request, Model model,
                         @RequestParam(name="page",defaultValue = "1") int page,
                         @RequestParam(name="size",defaultValue = "5") int size
                          ){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null && cookies.length!=0)
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
               User user=userMapper.findByToken(token);
               System.out.println(user.toString());
                if(user !=null) {
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        PageDTO pageDTO=listService.List(page,size);
        model.addAttribute("pageDTO",pageDTO);
        System.out.println("pageDTOLIst: "+ pageDTO.toString());
        return "index";
    }


}
