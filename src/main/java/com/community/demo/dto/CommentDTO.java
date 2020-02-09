package com.community.demo.dto;

import com.community.demo.Model.User;
import lombok.Data;

@Data
public class CommentDTO {
    private Integer id;
    private Integer parentId;
    private Integer type;
    private Integer commentator;
    private Long gmtCreate;
    private Long gmrModified;
    private Integer likeCount;
    private String comment;
    private Integer commentCount;
    private String content;
    private User user;
}

