package com.community.demo.controller;


import com.community.demo.dto.PageDTO;
import com.community.demo.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private ListService listService;

    @GetMapping("/")
    public String index2(HttpServletRequest request, Model model,
                         @RequestParam(name = "page", defaultValue = "1") int page,
                         @RequestParam(name = "size", defaultValue = "5") int size
    ) {
        PageDTO pageDTO = listService.List(page, size);
        model.addAttribute("pageDTO", pageDTO);
        System.out.println("pageDTOLIst: " + pageDTO.toString());
        return "index";
    }


}
