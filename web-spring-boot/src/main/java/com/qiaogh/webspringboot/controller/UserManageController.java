package com.qiaogh.webspringboot.controller;

import com.qiaogh.webspringboot.entity.User;
import com.qiaogh.webspringboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping( "manage" )
public class UserManageController {

    @Resource
    private UserService userService;

    @GetMapping( "page" )
    public String page( ModelMap modelMap ) {
        List<User> users = userService.query();
        modelMap.put( "users", users );
        return "userManage";
    }
}
