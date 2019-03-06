package com.mirr.tickets.annotation;

import com.mirr.tickets.auditoriums.AuditoriumServiceImpl;
import com.mirr.tickets.booking.BookingServiceImpl;
import com.mirr.tickets.dao.AuditoriumDao;
import com.mirr.tickets.dao.EventDao;
import com.mirr.tickets.dao.UserDao;
import com.mirr.tickets.discount.DiscountServiceImpl;
import com.mirr.tickets.events.EventServiceImpl;
import com.mirr.tickets.users.UserServiceImpl;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
public class AppConfig {


    @Bean
    public UserServiceImpl user() {
        return new UserServiceImpl();
    }

    @Bean
    public EventServiceImpl event() {
        return new EventServiceImpl();
    }

    @Bean
    public DiscountServiceImpl discount() {
        return new DiscountServiceImpl();
    }

    @Bean
    public BookingServiceImpl booking() {
        return new BookingServiceImpl();
    }

    @Bean
    public UserDao userDao() {
        return new UserDao();
    }

    @Bean
    public EventDao eventDao() {
        return new EventDao();
    }

    @Bean
    public AuditoriumDao auditoriumDao() {
        return new AuditoriumDao();
    }

    @Bean
    public AuditoriumServiceImpl auditoriums() {
        return new AuditoriumServiceImpl();
    }

    //    @Bean
//    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
//        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
//        propertyPlaceholderConfigurer.setLocation(new ClassPathResource("auditoriums.properties"));
//        return propertyPlaceholderConfigurer;
//    }
//
}
