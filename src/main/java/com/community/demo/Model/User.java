package com.community.demo.Model;

import lombok.Data;

@Data
public class User {
    private int ID;
    private String ACCOUNTID;
    private String NAME;
    private String TOKEN;
    private Long GMTCREATE;
    private Long GMTMODIFIED;
    private String picture;
}
