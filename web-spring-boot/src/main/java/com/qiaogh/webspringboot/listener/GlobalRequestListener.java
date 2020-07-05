package com.qiaogh.webspringboot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

@Slf4j
@Component
public class GlobalRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized( ServletRequestEvent sre ) {
        log.debug( "Global Request Listener initialized...." );
    }

    @Override
    public void requestDestroyed( ServletRequestEvent sre ) {
        log.debug( "Global Request Listener destroyed...." );
    }
}
