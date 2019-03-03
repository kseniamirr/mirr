package com.mirr.tickets.events;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EventDto {

    String name;
    double basePrice;
    EventRating eventRating;
    int id;
}
