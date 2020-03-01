package com.community.demo.dto;


import lombok.Data;

@Data
public class QuestionQueryDTO {
    private String search;
    private int size;
    private int page;
}
