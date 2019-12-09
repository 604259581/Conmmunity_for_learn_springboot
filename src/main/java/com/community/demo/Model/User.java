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
    private String pircture;
    public User(){}
    public User(String NAME,String ACCOUNTID,String TOKEN,Long GMTCREATE,Long GMTMODIFIED){
        this.GMTCREATE=GMTCREATE;
        this.GMTMODIFIED = GMTMODIFIED;
        this.ACCOUNTID=ACCOUNTID;
        this.TOKEN=TOKEN;
        this.NAME=NAME;
    }
}
