package com.mirr.tickets.events;

import com.mirr.tickets.auditoriums.AuditoriumDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;

@Setter
@Getter
public class EventDto {

    String name;
    double basePrice;
    EventRating eventRating;
    int id;
}
