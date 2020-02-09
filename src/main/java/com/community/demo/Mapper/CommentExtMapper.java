package com.community.demo.Mapper;

import com.community.demo.Model.Comment;
import com.community.demo.Model.CommentExample;
import com.community.demo.Model.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);

}