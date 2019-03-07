package com.mirr.tickets.annotation;

import com.mirr.tickets.auditoriums.AuditoriumServiceImpl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.mirr.tickets")
public class BaseConfig {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        AuditoriumServiceImpl auditoriumService = ctx.getBean(AuditoriumServiceImpl.class);

    }

}
