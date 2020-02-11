package com.community.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class TagsDTO {
    private String categoryName;
    List<String> tags;
}
