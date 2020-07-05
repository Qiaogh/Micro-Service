package com.qiaogh.webspringboot.handler;

import com.qiaogh.webspringboot.pojo.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler( Exception.class )
    @ResponseBody
    public ResultBean<?> handleException( Exception e ) {
        // 1、将错误信息记录下来
        log.error( "服务器产生了日志，日志信息", e );

        // 2、如果是重要的核心业务，给管理员发送消息
        // 主动通知相关负责人，系统出 bug 了，赶紧看日志
        // 发短信，发邮件

        // 3、给用户反馈
        return new ResultBean<>( "success", "当前服务器繁忙，请稍后再试！" );
    }

    @ExceptionHandler( MethodArgumentNotValidException.class )
    @ResponseBody
    public ResultBean<?> handleException( MethodArgumentNotValidException e ) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> errors = bindingResult.getFieldErrors();
        Iterator<FieldError> iterator = errors.iterator();
        FieldError error;
        Map<String, String> messages = new HashMap<>( errors.size() );
        while ( iterator.hasNext() ) {
            error = iterator.next();
            messages.put( error.getField(), error.getDefaultMessage() );
            log.error( "[{}]：[{}]", error.getField(), error.getDefaultMessage() );
        }
        return new ResultBean<>( "error", messages.toString() );
    }
}
