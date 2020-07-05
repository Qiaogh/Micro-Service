package com.qiaogh.webspringboot.service.impl;

import com.qiaogh.webspringboot.entity.User;
import com.qiaogh.webspringboot.mapper.UserMapper;
import com.qiaogh.webspringboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service( UserService.SERVICEKEY )
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int save( User user ) {
        return userMapper.save( user );
    }

    @Override
    public User get( Integer id ) {
        return userMapper.get( id );
    }

    @Override
    public List<User> query() {
        return userMapper.query();
    }

    @Override
    public void delete( Integer id ) {
        userMapper.delete( id );
    }
}
