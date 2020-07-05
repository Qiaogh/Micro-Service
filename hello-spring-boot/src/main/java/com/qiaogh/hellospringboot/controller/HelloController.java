package com.qiaogh.hellospringboot.controller;

import com.qiaogh.hellospringboot.config.Paths;
import com.qiaogh.hellospringboot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController // @Controller + @ResponseBody
@RequestMapping( "hello" )
@Slf4j
public class HelloController {

    private static Map<String, User> USER_DATA = new HashMap<>();

    @Resource
    private Paths paths;

    @GetMapping( "sayHello" )
    public String hello() {
        return "Hello！ Spring Boot！！！";
    }

    @PostMapping( "add" )
    public String add( @RequestBody User user ) {
        USER_DATA.put( user.getId(), user );
        return "add success!";
    }

    @GetMapping( "{id}" )
    public User getById( @PathVariable String id ) {
        log.debug( "获取编号为 {} 的用户", id );
        return USER_DATA.get( id );
    }

    @DeleteMapping( "{id}" )
    public String deleteById( @PathVariable String id ) {
        log.debug( "删除编号为 {} 的用户", id );
        USER_DATA.remove( id );
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
