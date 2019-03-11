package com.mirr.tickets.events;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

public interface EventService {

    Event save(Event event);

    void remove(int id);

    Optional<Event> getById(int id);

    Optional<Event> getEventByName(String name);

    Set<Event> getAllEvents();

    Seance saveSeance(String eventName, String auditoriumName, LocalDateTime airDate);

    Event getForDateRange(Date from, Date to);

    Event getNextEvents(Date to);

    void update(Event event,String [] params);
}
