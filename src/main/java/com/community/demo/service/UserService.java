package com.community.demo.service;

import com.community.demo.Mapper.UserMapper;
import com.community.demo.Model.User;
import com.community.demo.Model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public void createOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountidEqualTo(user.getAccountid());
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size()==0){
            user.setGmtcreate(System.currentTimeMillis());
            user.setGmtmodified(System.currentTimeMillis());
            userMapper.insert(user);
        }else {
            User updateUser=users.get(0);
            User dbUser=new User();
            dbUser.setGmtmodified(System.currentTimeMillis());
            dbUser.setPicture(user.getPicture());
            dbUser.setName(user.getName());
            dbUser.setToken(user.getToken());
            UserExample example = new UserExample();
            example.createCriteria().andIdEqualTo(updateUser.getId());
            userMapper.updateByExampleSelective(dbUser,example);
        }
    }
}
