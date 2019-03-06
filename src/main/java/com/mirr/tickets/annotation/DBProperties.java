package com.mirr.tickets.annotation;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("auditoriums.properties")
@Getter
public class DBProperties {


    @Value("${db.auditoriumNames}")
    private String auditoriumNames;

    @Value("${db.numberOfSeats}")
    private String auditoriumSeatsNumber;


    @Value("${db.vipSeats}")
    private String auditoriumVIPSeats;

}
