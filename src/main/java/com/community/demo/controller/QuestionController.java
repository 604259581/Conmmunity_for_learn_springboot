package com.community.demo.controller;

import com.community.demo.dto.CommentDTO;
import com.community.demo.dto.QuestionDTO;
import com.community.demo.enums.CommentTypeEnum;
import com.community.demo.service.CommentService;
import com.community.demo.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private ListService listService;
    @Autowired
    private CommentService commentService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name="id") int id, Model model){
        listService.incView(id);
        QuestionDTO questionDTO =listService.getByID(id);
        List<QuestionDTO> selectRelated =listService.selectedRelated(questionDTO);
        List<CommentDTO> comments = commentService.listByTargetId(id,CommentTypeEnum.QUESTION);

        model.addAttribute("quetion",questionDTO);
        model.addAttribute("comments",comments);
        model.addAttribute("selectRelated",selectRelated);
        System.out.println(questionDTO);
        return "question";
    }
}
