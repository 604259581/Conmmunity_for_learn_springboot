package com.community.demo.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private int parentId;
    private String content;
    private int type;
}
