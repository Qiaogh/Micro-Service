package com.qiaogh.webspringboot.config;

import com.qiaogh.webspringboot.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private UserInterceptor userInterceptor;

    @Override
    public void addInterceptors( InterceptorRegistry registry ) {
        registry.addInterceptor( userInterceptor ).addPathPatterns( "/user/*" );
    }
}
