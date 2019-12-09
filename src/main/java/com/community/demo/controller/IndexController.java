package com.community.demo.controller;


import com.community.demo.Mapper.UserMapper;
import com.community.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @Autowired
    private UserMapper userMapper;
    @GetMapping("index")
    public String index2(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies.length!=0 && cookies!=null)
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


        return "index";
    }


}
