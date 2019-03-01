package com.mirr.tickets.events;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.datetime.joda.DateTimeParser;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
public class EventServiceDto {

    String name;
    int priceForTicket;
    int id;
    String email;
    Date from;
    Date to;
    LocalDateTime dateTime;

}
