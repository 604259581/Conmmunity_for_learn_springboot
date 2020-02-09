package com.community.demo.service;
import com.community.demo.Mapper.QuestionExtMapper;
import com.community.demo.Mapper.QuestionMapper;
import com.community.demo.Mapper.UserMapper;
import com.community.demo.Model.Question;
import com.community.demo.Model.QuestionExample;
import com.community.demo.Model.User;
import com.community.demo.dto.PageDTO;
import com.community.demo.dto.QuestionDTO;
import com.community.demo.exception.CustomizeErrorCode;
import com.community.demo.exception.CustomizeException;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListService {
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    QuestionExtMapper questionExtMapper;
    @Autowired
    UserMapper userMapper;

    public void incView(int id) {
        Question question = new Question();
        question.setId(id);
        question.setViewCount(1);
        questionExtMapper.incView(question);
    }

    public PageDTO List(int page, int size) {

        PageDTO pageDTO=new PageDTO();
        int totalCount= (int)questionMapper.countByExample(new QuestionExample());
        pageDTO.setPagination(totalCount,page,size);
        if(page<1){
            page=1;
        }
        if(page>pageDTO.getTotalPage()){
            page=pageDTO.getTotalPage();
        }
        int offset = size*(page-1);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        QuestionExample questionExample =new QuestionExample();
        questionExample.setOrderByClause("gmt_create desc");
        List<Question> questionList = questionMapper.selectByExampleWithRowbounds(questionExample, new RowBounds(offset, size));
        int userid;
        for (Question question : questionList) {
            userid = question.getCreator();
            User user = userMapper.selectByPrimaryKey(userid);
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
        QuestionExample questionExample=new QuestionExample();
        questionExample.createCriteria()
                .andCreatorEqualTo(userid);
        int totalCount= (int)questionMapper.countByExample(questionExample);
        pageDTO.setPagination(totalCount,page,size);
        if(page>pageDTO.getTotalPage()){
            page=pageDTO.getTotalPage();
        }
        if(page<1){
            page=1;
        }
        int offset = size*(page-1);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        QuestionExample example = new QuestionExample();
        example.createCriteria()
                .andCreatorEqualTo(userid);
        List<Question> questionList =questionMapper.selectByExampleWithRowbounds(example,new RowBounds(offset,size));
        for (Question question : questionList) {
            userid = question.getCreator();
            User user = userMapper.selectByPrimaryKey(userid);
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);//spring自带的类型转换类型
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        pageDTO.setQuestionDTOList(questionDTOList);


        return pageDTO;
    }


    public QuestionDTO getByID(int id) {
        Question question=questionMapper.selectByPrimaryKey(id);
        if(question == null){
            throw new CustomizeException(CustomizeErrorCode.Question_NOT_FOUND);
        }
        QuestionDTO questionDTO= new QuestionDTO();
        BeanUtils.copyProperties(question,questionDTO);
        User user = userMapper.selectByPrimaryKey(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }

    public List<QuestionDTO> selectedRelated(QuestionDTO queryDTO) {
        if(StringUtils.isBlank(queryDTO.getTag())){
            return new ArrayList<>();
        }
        String tag = queryDTO.getTag().replaceAll(",", "|");
        Question question = new Question();
        question.setId(queryDTO.getId());
        question.setTag(tag);
        List<Question> questions = questionExtMapper.selectRelated(question);
        List<QuestionDTO> questionDTOs = questions.stream().map(q -> {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(q, questionDTO);
            return questionDTO;
        }).collect(Collectors.toList());
        return questionDTOs;
    }
}
