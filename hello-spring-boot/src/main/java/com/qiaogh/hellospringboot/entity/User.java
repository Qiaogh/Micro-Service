package com.qiaogh.hellospringboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude
public class User {

    private String id;
    private String name;
    private Integer age;
    @JsonFormat( pattern = "yyyy-MM-dd" )
    private Date birthday;
    private Date entryDate = new Date();
}
