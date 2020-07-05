package com.qiaogh.webspringboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 封装统一的响应数据
 * @param <T> 相应数据类型
 */
@Data
@AllArgsConstructor
public class ResultBean<T> {

    // 响应状态
    private String status;

    // 响应数据
    private T data;
}
