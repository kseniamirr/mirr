package com.mirr.tickets.events;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EventService {

    Event save(Event event);

    void remove(int id);

    Optional<Event> getById(int id);

    Event getEventByName(String name);

    List<Event> getAllEvents();

    SeanceDto saveSeance(String eventName, String auditoriumName, LocalDateTime airDate);

    Event getForDateRange(Date from, Date to);

    Event getNextEvents(Date to);

    void update(Event event,String [] params);
}
