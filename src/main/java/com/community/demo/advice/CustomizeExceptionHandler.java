package com.community.demo.advice;

import com.alibaba.fastjson.JSON;
import com.community.demo.dto.ResultDTO;
import com.community.demo.exception.CustomizeErrorCode;
import com.community.demo.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ModelAndView handleControllerException(Throwable e, Model model, HttpServletRequest request, HttpServletResponse response) {
        String cotentType = request.getContentType();
        if ("application/json".equals(cotentType)) {
            //返回json
            ResultDTO resultDTO;
            if (e instanceof CustomizeException) {
                resultDTO = ResultDTO.erroroOf((CustomizeException) e);
            } else {
                resultDTO = ResultDTO.erroroOf(CustomizeErrorCode.SYSTEM_ERROE);
            }
            try {
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("UTF-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return null;
        }else {
            //错误页面跳转
            if (e instanceof CustomizeException) {
                model.addAttribute("message", e.getMessage());
            } else {
                model.addAttribute("message",CustomizeErrorCode.SYSTEM_ERROE.getMessage());
            }
            return new ModelAndView("error");
        }


    }

}