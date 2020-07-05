package com.qiaogh.webspringboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties( prefix = "paths" )
public class Paths {

    private String imageServer;

    private String emailServer;
}
