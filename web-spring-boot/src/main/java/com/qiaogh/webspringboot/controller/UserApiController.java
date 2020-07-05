package com.qiaogh.webspringboot.controller;

import com.qiaogh.webspringboot.config.Paths;
import com.qiaogh.webspringboot.entity.User;
import com.qiaogh.webspringboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.Validate;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController // @Controller + @ResponseBody
@RequestMapping( "user" )
@Slf4j
public class UserApiController {

    @Resource
    private UserService userService;

    @Resource
    private Paths paths;

    @GetMapping( "sayHello" )
    public String hello() {
        return "Hello！ Spring Boot！！！";
    }

    @PostMapping( "add" )
    public String add( @RequestBody @Valid User user ) {
        userService.save( user );
        return "add success！用户编号：" + user.getId();
    }

    @GetMapping( "{id}" )
    public User getById( @PathVariable Integer id ) {
        log.debug( "获取编号为 {} 的用户", id );
        User user = userService.get( id );
        Validate.isTrue( user != null, "没有找到用户信息！编号：" + id );
        return user;
    }

    @DeleteMapping( "{id}" )
    public String deleteById( @PathVariable Integer id ) {
        log.debug( "删除编号为 {} 的用户", id );
        userService.delete( id );
        return "delete success";
    }

    @GetMapping( "getImageServer" )
    public String getImageServer() {
        return paths.getImageServer();
    }

    @GetMapping( "getEmailServer" )
    public String getEmailServer() {
        return paths.getEmailServer();
    }
}
