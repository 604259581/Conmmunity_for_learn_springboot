package com.community.demo.controller;


import com.community.demo.Mapper.QuestionMapper;
import com.community.demo.Model.Question;
import com.community.demo.Model.User;
import com.community.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionMapper questionMapper;


    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name="id") int id,Model model){
        Question question = questionMapper.selectByPrimaryKey(id);
        model.addAttribute("title", question.getTitle());
        model.addAttribute("description", question.getDescription());
        model.addAttribute("tag", question.getTag());
        model.addAttribute("id",question.getId());
        return "publish";
    }


    @PostMapping("/publish")
    public String topublish(
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "description",required =false) String description,
            @RequestParam(value = "tag",required = false) String tag,
            @RequestParam(value = "id" ,required = false) int id,
            HttpServletRequest request, Model model) {

        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);
        if (title == null || title == "") {
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if (description == null || description == "") {
            model.addAttribute("error", "问题不能为空");
            return "publish";
        }
        if (tag == null || tag == "") {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }

        Question quesion = new Question();
        quesion.setTitle(title);
        quesion.setDescription(description);
        quesion.setTag(tag);
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        quesion.setCreator(user.getId());

        System.out.println("quesion: " + quesion.toString());
        quesion.setId(id);
        questionService.createOrUpdate(quesion);

        if (user == null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }
        return "redirect:/";
    }

}
