package com.community.demo.controller;

import com.community.demo.Model.Question;
import com.community.demo.dto.QuestionDTO;
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
    ListService listService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name="id") int id, Model model){
        QuestionDTO questionDTO =listService.getByID(id);
        model.addAttribute("quetion",questionDTO);
        return "question";
    }
}
