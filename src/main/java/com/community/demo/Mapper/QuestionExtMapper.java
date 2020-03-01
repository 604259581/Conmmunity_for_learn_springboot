package com.community.demo.Mapper;

import com.community.demo.Model.Question;
import com.community.demo.dto.QuestionQueryDTO;

import java.util.List;


public interface QuestionExtMapper {
    int incView(Question question);
    int incCommentCount(Question question);
    List<Question> selectRelated(Question question);
    Integer countBySearch(QuestionQueryDTO questionQueryDTO);
    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}