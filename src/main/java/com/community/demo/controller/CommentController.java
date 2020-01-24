package com.community.demo.controller;

import com.community.demo.Mapper.CommentMapper;
import com.community.demo.Model.Comment;
import com.community.demo.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommentController {
    @Autowired
    CommentMapper commentMapper;
    @RequestMapping(value ="/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setComment
        comment.setCommentator();
        commentMapper.insert(comment);
    }
}
