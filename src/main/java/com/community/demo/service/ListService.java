package com.community.demo.service;

import com.community.demo.Mapper.QuestionMapper2;
import com.community.demo.Mapper.UserMapper;
import com.community.demo.Model.Question;
import com.community.demo.Model.User;
import com.community.demo.dto.PageDTO;
import com.community.demo.dto.QuestionDTO;
import com.community.demo.interceptors.Webconfig;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListService {
    @Autowired
    QuestionMapper2 questionMapper;
    @Autowired
    UserMapper userMapper;

    public PageDTO List(int page, int size) {

        PageDTO pageDTO=new PageDTO();
        int totalCount= questionMapper.selectCount();
        pageDTO.setPagination(totalCount,page,size);
        if(page<1){
            page=1;
        }
        if(page>pageDTO.getTotalPage()){
            page=pageDTO.getTotalPage();
        }
        int offset = size*(page-1);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        List<Question> questionList = questionMapper.selectList(offset,size);

        int userid;
        for (Question question : questionList) {
            userid = question.getCreator();
            User user = userMapper.findByID(userid);
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);//spring自带的类型转换类型
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        pageDTO.setQuestionDTOList(questionDTOList);


        return pageDTO;

    }


    public PageDTO List(int userid, int page, int size) {
        PageDTO pageDTO=new PageDTO();
        int totalCount= questionMapper.countByUserID(userid);
        pageDTO.setPagination(totalCount,page,size);
        if(page>pageDTO.getTotalPage()){
            page=pageDTO.getTotalPage();
        }
        if(page<1){
            page=1;
        }
        int offset = size*(page-1);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        List<Question> questionList = questionMapper.pfofileList(userid,offset,size);
        for (Question question : questionList) {
            userid = question.getCreator();
            User user = userMapper.findByID(userid);
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);//spring自带的类型转换类型
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        pageDTO.setQuestionDTOList(questionDTOList);


        return pageDTO;
    }


    public QuestionDTO getByID(int id) {
        Question question=questionMapper.getByID(id);
        QuestionDTO questionDTO= new QuestionDTO();
        BeanUtils.copyProperties(question,questionDTO);
        User user = userMapper.findByID(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }
}
