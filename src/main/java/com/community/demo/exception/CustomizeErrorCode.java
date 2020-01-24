package com.community.demo.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    Question_NOT_FOUND("你找的问题不存在,要不换一个试试");
    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
