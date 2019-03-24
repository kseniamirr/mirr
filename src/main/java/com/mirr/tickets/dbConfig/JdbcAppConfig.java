package com.mirr.tickets.dbConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcAppConfig {

    @Autowired
    private BeanDefinitionProperty beanDefinitionProperty;


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(beanDefinitionProperty.getDriverClassName());
        dataSource.setUrl(beanDefinitionProperty.getHost());
        dataSource.setUsername(beanDefinitionProperty.getUser());
        dataSource.setPassword(beanDefinitionProperty.getPassword());

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
       JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
       jdbcTemplate.setResultsMapCaseInsensitive(true);
       return jdbcTemplate;
    }
}
