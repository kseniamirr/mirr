package com.mirr.tickets.dao;

import com.mirr.tickets.auditoriums.Auditorium;
import com.mirr.tickets.events.Event;
import com.mirr.tickets.events.EventServiceImpl;
import com.mirr.tickets.events.SeanceDto;
import com.mirr.tickets.users.User;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Setter
public class EventDao implements GenericDao<Event> {

    private NavigableSet<Event> eventsSet = new TreeSet<Event>(EventDao::compareById);

    public static NavigableSet<SeanceDto> seanceDtoSet = new TreeSet<>(EventServiceImpl::compareByEventAuditoriumDate);

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
    public Set<Event> getAll() {
        return eventsSet;
    }

    @Override
    public Optional<Event> getById(int id) {
        Event event = new Event();
        event.setId(id);
        Event eventIdResult = eventsSet.ceiling(event);
        if (eventIdResult != null && eventIdResult.getId() != id) {
            return Optional.empty();
        }
        return Optional.of(eventIdResult);
    }

    @Override
    public void update(Event event, String[] params) {

    }

    public Optional<Event> getEventByName(String name) {
        Event event = new Event();
        event.setName(name);

        List<Event> eventList = new ArrayList<>(eventsSet);
        Collections.sort(eventList, EventDao::compareByName);

        int pos = Collections.binarySearch(eventList, event, EventDao::compareByName);
        return pos != -1 ? Optional.of(eventList.get(pos)) : Optional.empty();
    }

    public static int compareByName(Event event1, Event event2) {
        if (event1 == event2) return 0;
        if (event1 == null) return -1;
        if (event1.getName() == event2.getName()) return 0;
        if (event1.getName() == null) return -1;
        return event1.getName().compareTo(event2.getName());
    }

    private static int compareById(Event event1, Event event2) {
        if (event1 == event2) return -1;
        if (event1 == null) return 0;
        if (event1.getId() == event2.getId()) return 0;
        if (event1.getId() < event2.getId()) return -1;
        return 1;
    }

/*

    public NavigableSet<LocalDateTime> airDates = new TreeSet<>();

    public NavigableMap<LocalDateTime, Auditorium> auditoriums = new TreeMap<>();

    public List<Event> eventList = new ArrayList<>(eventsSet);
    */


}
