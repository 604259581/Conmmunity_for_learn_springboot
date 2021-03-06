package com.community.demo.controller;

import com.community.demo.Model.User;
import com.community.demo.dto.AcessTokenDTO;
import com.community.demo.dto.GithubUser;
import com.community.demo.provider.GuihubProvider;
import com.community.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


/**
 *
 */
@Controller
@Slf4j
public class AuthorizeController {
    @Autowired
    private GuihubProvider githubProvider;
    @Value("${GitHub.setClient_id}")
    private String clientid;
    @Value("${GitHub.setClient_secrect}")
    private String secrect;
    @Value("${GitHub.setRedirect_uri}")
    private String uri;
    @Autowired
    private UserService userService;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response) {
        AcessTokenDTO acessTokenDTO = new AcessTokenDTO();
        acessTokenDTO.setClient_id(clientid);
        acessTokenDTO.setClient_secrect(secrect);
        acessTokenDTO.setCode(code);
        acessTokenDTO.setRedirect_uri(uri);
        acessTokenDTO.setState(state);
        // System.out.println("code："+code+"  state="+state);
        //String accessToken=githubProvider.getAccessToken(acessTokenDTO);
        GithubUser user = githubProvider.getUserMessage("614f28e2f81a78e8ee3d0b9670b3b34b0d356b50");
        System.out.println(user);
        if (user != null) {
            String token = UUID.randomUUID().toString();
            User user_2 = new User();
            user_2.setName(user.getName());
            user_2.setAccountid(String.valueOf(user.getId()));
            user_2.setToken(token);
            user_2.setPicture(user.getAvatar_url());
            userService.createOrUpdate(user_2);
            System.out.println("user_2: " + user_2);
            response.addCookie(new Cookie("token", token));
            //登录成功，建立session
            //thymeleaf就是一个模板引擎，作用就是将非常简单的方法把后端数据给前端使用。
            //这里不用自己设置session是因为框架thymeleaf会自动注入session，session的value是随机的
            //request.getSession().setAttribute("user",user);
            //redirect:将值全去掉，重新加载地址；
            return "redirect:/";
        } else {
            log.error("callback get github error,{}", user);
            return "redirect:/";
        }

    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }



}
