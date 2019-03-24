package com.mirr.tickets.dbConfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("jdbcProp.properties")
@Getter
@Setter
public class BeanDefinitionProperty {

    @Value("${driverClassName}")
    private String driverClassName;

    @Value("${host}")
    private String host;

    @Value("${port}")
    private Integer port;

    @Value("${user}")
    private String user;

    @Value("${password}")
    private String password;

}
