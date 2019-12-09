package com.community.demo.controller;


import com.community.demo.Mapper.QuestionMapper;
import com.community.demo.Mapper.UserMapper;
import com.community.demo.Model.Quesion;
import com.community.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
    @PostMapping("/publish")
    public String topublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest request, Model model){

        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        if(title==null || title==""){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        if(description==null || description==""){
            model.addAttribute("error","问题不能为空");
            return "publish";
        }
        if(tag==null || tag==""){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }

        Quesion quesion = new Quesion();
        quesion.setTitle(title);
        quesion.setDescription(description);
        quesion.setTag(tag);
        User user=null;
        Cookie[] cookies = request.getCookies();
        if(cookies.length!=0 && cookies!=null)
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                user=userMapper.findByToken(token);
                if(user !=null) {
                    request.getSession().setAttribute("user",user);
                }
                quesion.setCreator(user.getID());
                quesion.setGmt_create(System.currentTimeMillis());
                quesion.setGmt_modified(System.currentTimeMillis());
                break;
            }
        }
        System.out.println("quesion: "+quesion.toString());
        questionMapper.create(quesion);
        if(user==null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }
        return "redirect:index";
    }

}
