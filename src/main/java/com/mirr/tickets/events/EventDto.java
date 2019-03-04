package com.mirr.tickets.events;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EventDto {

    private String name;
    private double basePrice;
    private EventRating eventRating;
    private int id;

}
