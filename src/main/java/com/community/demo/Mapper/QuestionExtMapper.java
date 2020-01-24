package com.community.demo.Mapper;

import com.community.demo.Model.Question;
import com.community.demo.Model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question question);
}