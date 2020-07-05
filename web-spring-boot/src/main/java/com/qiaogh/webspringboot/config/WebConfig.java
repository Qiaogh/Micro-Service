package com.qiaogh.webspringboot.config;

import com.qiaogh.webspringboot.filter.UserFilter;
import com.qiaogh.webspringboot.listener.GlobalRequestListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class WebConfig {

    @Resource
    private UserFilter userFilter;

    @Resource
    private GlobalRequestListener globalRequestListener;

    @Bean
    public FilterRegistrationBean<UserFilter> registerUserFilter() {
        FilterRegistrationBean<UserFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter( userFilter );
        filterRegistrationBean.setName( "userFilter" );
        filterRegistrationBean.addUrlPatterns( "/user/*" );
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<GlobalRequestListener> registrationUserRequestListener() {
        ServletListenerRegistrationBean<GlobalRequestListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
        servletListenerRegistrationBean.setListener( globalRequestListener );
        return servletListenerRegistrationBean;
    }
}
