package com.qiaogh.webspringboot.service;

import com.qiaogh.webspringboot.entity.User;

import java.util.List;

public interface UserService {

    String SERVICEKEY = "userService";

    int save( User user );

    User get( Integer id );

    List<User> query();

    void delete( Integer id );
}
