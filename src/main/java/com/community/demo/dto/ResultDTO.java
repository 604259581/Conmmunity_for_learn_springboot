package com.community.demo.dto;

import com.community.demo.exception.CustomizeErrorCode;
import com.community.demo.exception.CustomizeException;
import lombok.Data;
import org.springframework.web.servlet.ModelAndView;

@Data
public class ResultDTO<T> {
    private Integer code;
    private String  message;
    private T data; //泛型
    public static ResultDTO erroroOf(Integer code ,String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO erroroOf(CustomizeErrorCode errorCode) {
        return erroroOf(errorCode.getCode(),errorCode.getMessage());
    }

    public static ResultDTO okOf(){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        return resultDTO;
    }


    public static ResultDTO erroroOf(CustomizeException e) {
        return erroroOf(e.getCode(),e.getMessage());
    }


    public static <T>ResultDTO okOf(T t)
    {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        resultDTO.setData(t);
        return resultDTO;
    }
}
