package com.community.demo.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    Question_NOT_FOUND(2001,"你找的问题不存在,要不换一个试试"),
    TARGET_PARAM_NOT_FOUND(2002,"未任何问题或评论进行回复"),
    NO_LOGIN(2003,"当前操作需要登录，请登录后重试"),
    SYSTEM_ERROE(2004,"系统冒烟了，要不待会儿再试试！"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND (2006,"你操作的评论不存在"),
    CONTENT_IS_EMPTY(2007,"输入评论不能为空");
    private String message;
    private Integer code;
    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code=code;
    }
    @Override
    public Integer getCode() {
        return code;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
