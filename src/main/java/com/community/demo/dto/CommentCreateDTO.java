package com.community.demo.dto;

import lombok.Data;

@Data
public class CommentCreateDTO {
    private int parentId;
    private String content;
    private int type;
}
