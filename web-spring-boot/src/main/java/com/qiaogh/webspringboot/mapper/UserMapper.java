package com.qiaogh.webspringboot.mapper;

import com.qiaogh.webspringboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int save( User user );

    User get( Integer id );

    List<User> query();

    void delete( Integer id );

}
