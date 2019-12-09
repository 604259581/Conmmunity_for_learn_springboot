package com.community.demo.service;

import com.community.demo.Mapper.QuestionMapper;
import com.community.demo.Mapper.UserMapper;
import com.community.demo.Model.Question;
import com.community.demo.Model.User;
import com.community.demo.dto.QuestionDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListService {
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    UserMapper userMapper;

    public List<QuestionDTO> List() {
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        List<Question> questionList = questionMapper.selectList();
        int userid;
        for (Question question : questionList) {
            userid = question.getId();
            User user = userMapper.findByID(userid);
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);//spring自带的类型转换类型
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;

    }



}
