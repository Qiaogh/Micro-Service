package com.qiaogh.webspringboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@JsonInclude
public class User {

    private Integer id;
    @NotBlank( message = "用户名不可为空！" )
    private String name;
    @Min( value = 15, message = "用户年龄必须大于 15 才可以注册！" )
    private Integer age;
    @JsonFormat( pattern = "yyyy-MM-dd" )
    private Date birthday;
    private Date entryTime = new Date();
}
