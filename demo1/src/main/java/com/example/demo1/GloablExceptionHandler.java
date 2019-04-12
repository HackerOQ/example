package com.example.demo1;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Company: sunyard
 * @Author: Ouqiang
 * @CreateTime: 2019/04/12 15:34
 * @Description: 全局捕获异常
 */
@ControllerAdvice
public class GloablExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public String exceptionHandler(HttpServletRequest request, Exception e){
        return "error!";
    }
}