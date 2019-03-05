package com.mirr.tickets.dao;

import com.mirr.tickets.auditoriums.Auditorium;
import com.mirr.tickets.events.Event;
import com.mirr.tickets.events.EventServiceImpl;
import com.mirr.tickets.events.SeanceDto;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Setter
public class EventDao implements GenericDao<Event>{

    private NavigableSet<Event> eventsSet = new TreeSet<>(EventServiceImpl::compareByName);

    public static NavigableSet<SeanceDto> seanceDtoSet = new TreeSet<>(EventServiceImpl::compareByEventAuditoriumDate);

    public NavigableSet<LocalDateTime> airDates = new TreeSet<>();

    public NavigableMap<LocalDateTime, Auditorium> auditoriums = new TreeMap<>();

    public List<Event> eventList = new ArrayList<>(eventsSet);


    @Override
    public void save(Event event) {
        if (event.getName() == null) {
            try {
                event.setName(eventsSet.last().getName() + 1);
            } catch (NoSuchElementException e) {
                event.setName(null);
            }
        }
        eventsSet.add(event);
    }

    @Override
    public void remove(Event event) {
        eventsSet.remove(event);
    }

    public void remove(int id) {
        Optional<Event> event = eventsSet.stream().filter(e -> e.getId() == id).findFirst();
        if (event.isPresent()) {
            eventsSet.remove(event.get());
        }
    }

    @Override
    public List<Event> getAll() {
        return eventList;
    }

    @Override
    public Optional<Event> get(Event event) {
        return Optional.ofNullable(event);
    }

    public Event getById(int id) {
        Event event = new Event();
        event.setId(id);
        Event eventIdResult = eventsSet.ceiling(event);
        if (eventIdResult != null && eventIdResult.getId() != id) {
            return null;
        }
        return eventIdResult;
    }

    @Override
    public void update(Event event, String[] params) {

    }
}
