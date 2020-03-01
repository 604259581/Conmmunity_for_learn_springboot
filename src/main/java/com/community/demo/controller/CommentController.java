package com.community.demo.controller;

import com.community.demo.Model.Comment;
import com.community.demo.Model.User;
import com.community.demo.dto.CommentCreateDTO;
import com.community.demo.dto.CommentDTO;
import com.community.demo.dto.ResultDTO;
import com.community.demo.enums.CommentTypeEnum;
import com.community.demo.exception.CustomizeErrorCode;
import com.community.demo.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    @ResponseBody
    @RequestMapping(value ="/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                        HttpServletRequest request){ // @requestBody 是传json数据
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return ResultDTO.erroroOf(CustomizeErrorCode.NO_LOGIN);
        }
        if(commentCreateDTO == null || StringUtils.isBlank(commentCreateDTO.getContent())){
            return ResultDTO.erroroOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }
        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setComment(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmrModified(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0);
        commentService.insert(comment,user);
        return ResultDTO.okOf(); // @ResponseBody会自动将它转成json
    }
    @ResponseBody
    @RequestMapping(value ="/comment/{id}", method = RequestMethod.GET)
    public ResultDTO<List<ResultDTO>> comments(@PathVariable(name="id") Integer id){
        System.out.println(id);
        List<CommentDTO> commentDTOS = commentService.listByTargetId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }
}
