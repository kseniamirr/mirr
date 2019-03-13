package com.mirr.tickets.dbConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanDefinitionProperty {

    @Value("${host}")
    private String host;

    @Value("${user}")
    private String user;

    @Value("${password}")
    private String password;

    @Value("${port}")
    private Integer port;
}
