package com.community.demo.service;

import com.community.demo.Mapper.UserMapper;
import com.community.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public void createOrUpdate(User user) {
        User dbUser=userMapper.findByAccountID(user.getACCOUNTID());
        if(dbUser==null){
            user.setGMTCREATE(System.currentTimeMillis());
            user.setGMTMODIFIED(System.currentTimeMillis());
            userMapper.insert(user);
        }else {
            dbUser.setGMTMODIFIED(System.currentTimeMillis());
            dbUser.setPicture(user.getPicture());
            dbUser.setNAME(user.getNAME());
            dbUser.setTOKEN(user.getTOKEN());
            userMapper.update(dbUser);
        }
    }
}
