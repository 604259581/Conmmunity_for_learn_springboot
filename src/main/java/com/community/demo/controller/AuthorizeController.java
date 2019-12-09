package com.community.demo.controller;

import com.community.demo.Mapper.UserMapper;
import com.community.demo.Model.User;
import com.community.demo.dto.AcessTokenDTO;
import com.community.demo.dto.GithubUser;
import com.community.demo.provider.GuihubProvider;
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
    private UserMapper userMapper; //这是一个idea的bug，自动注入mapper会报错
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state")String state,
                           HttpServletResponse response) {
        AcessTokenDTO acessTokenDTO = new AcessTokenDTO();
        acessTokenDTO.setClient_id(clientid);
        acessTokenDTO.setClient_secrect(secrect);
        acessTokenDTO.setCode(code);
        acessTokenDTO.setRedirect_uri(uri);
        acessTokenDTO.setState(state);
       // System.out.println("code："+code+"  state="+state);
        //String accessToken=githubProvider.getAccessToken(acessTokenDTO);
        GithubUser user=githubProvider.getUserMessage("110edea834eea1fd7fe00a2d7fe27263f6da0021");
        System.out.println(user);
        if(user!=null){
            String token = UUID.randomUUID().toString();
            User user_2 = new User(user.getName(),String.valueOf(user.getId()), token,System.currentTimeMillis(),System.currentTimeMillis());
            user_2.setPircture(user.getAvatar_url());
            System.out.println("user_2: "+user_2);
            userMapper.insert(user_2);
            response.addCookie(new Cookie("token",token));
            //登录成功，建立session
            //thymeleaf就是一个模板引擎，作用就是将非常简单的方法把后端数据给前端使用。
            //这里不用自己设置session是因为框架thymeleaf会自动注入session，session的value是随机的
            //request.getSession().setAttribute("user",user);
            //redirect:将值全去掉，重新加载地址；
            return "redirect:index";
        }else{
            return "redirect:index";
        }

    }
}
