package com.community.demo.Mapper;

import com.community.demo.Model.Question;

import java.util.List;


public interface QuestionExtMapper {
    int incView(Question question);
    int incCommentCount(Question question);
    List<Question> selectRelated(Question question);
}