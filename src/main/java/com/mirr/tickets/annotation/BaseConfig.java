package com.mirr.tickets.annotation;

import com.mirr.tickets.auditoriums.AuditoriumServiceImpl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.mirr.tickets")
@EnableAspectJAutoProxy
public class BaseConfig {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BaseConfig.class);
    }

}
