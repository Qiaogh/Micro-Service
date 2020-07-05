package com.qiaogh.webspringboot.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
@Component
public class UserFilter implements Filter {

    @Override
    public void init( FilterConfig filterConfig ) throws ServletException {
        log.debug( "User Filter init...." );
    }

    @Override
    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException, ServletException {
        log.debug( "User Filter invoking...." );

        // 调用下一个 Filter
        chain.doFilter( request, response );

        log.debug( "User Filter invoked...." );
    }

    @Override
    public void destroy() {
        log.debug( "User Filter destory...." );
    }
}
