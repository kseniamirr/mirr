package com.mirr.tickets.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;


@Configuration
@PropertySource("classpath:db.auditoriums.properties")
@ComponentScan
public class DBProperties {


    @Value("${db.auditoriumNames}")
    public String auditoriumNames;

    @Value("${db.numberOfSeats}")
    public String auditoriumSeatsNumber;


    @Value("${db.vipSeats}")
    public List<String> auditoriumVIPSeats;

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertyPlaceholderConfigurer();
    }
}
