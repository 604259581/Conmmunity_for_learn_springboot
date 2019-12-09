package com.community.demo.controller;


import com.community.demo.Mapper.UserMapper;
import com.community.demo.Model.User;
import com.community.demo.dto.QuestionDTO;
import com.community.demo.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ListService listService;
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
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        questionDTOList=listService.List();
        System.out.println("questionDTOLIst: "+ questionDTOList.toString());
        return "index";
    }


}
