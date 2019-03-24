package com.mirr.tickets.dao;

import com.mirr.tickets.events.Event;
import com.mirr.tickets.events.EventServiceImpl;
import com.mirr.tickets.events.Seance;
import org.springframework.stereotype.Component;

import java.util.*;

@Component

public class EventDaoImpl implements EventDao {

    private static NavigableSet<Event> eventsSet = new TreeSet<Event>(EventDaoImpl::compareById);

    public static NavigableSet<Seance> seanceSet = new TreeSet<>(EventServiceImpl::compareByEventAuditoriumDate);

    @Override
    public Event add(Event event) {
        if (event.getEventId() == 0) {
            try {
                event.setEventId(eventsSet.last().getEventId() + 1);
            } catch (NoSuchElementException e) {
                event.setEventId(1);
            }
        }
        eventsSet.add(event);
        return event;
    }

    @Override
    public void delete(Event event) {
        eventsSet.remove(event);
    }

    public void remove(int id) {
        Optional<Event> event = eventsSet.stream().filter(e -> e.getEventId() == id).findFirst();
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
        event.setEventId(id);
        Event eventIdResult = eventsSet.ceiling(event);
        if (eventIdResult != null && eventIdResult.getEventId() != id) {
            return Optional.empty();
        }
        return Optional.of(eventIdResult);
    }

    @Override
    public void update(Event event, String[] params) {

    }

       public Optional<Event> getEventByName(String name) {
        Event event = new Event();
        event.setEventName(name);

        List<Event> eventList = new ArrayList<>(eventsSet);
        Collections.sort(eventList, EventDaoImpl::compareByName);

        int pos = Collections.binarySearch(eventList, event, EventDaoImpl::compareByName);
        return pos > -1 ? Optional.of(eventList.get(pos)) : Optional.empty();
    }

    @Override
    public Seance saveSeance(Seance seance) {
        int seanceId;
        try {
            seanceId = seanceSet.last().getSeanceId() + 1;
        } catch (NoSuchElementException e) {
            seanceId = 1;
        }

        seance.setSeanceId(seanceId);
        seanceSet.add(seance);
        return seance;
    }

    public static int compareByName(Event event1, Event event2) {
        if (event1 == event2) return 0;
        if (event1 == null) return -1;
        if (event1.getEventName() == event2.getEventName()) return 0;
        if (event1.getEventName() == null) return -1;
        return event1.getEventName().compareTo(event2.getEventName());
    }

    private static int compareById(Event event1, Event event2) {
        if (event1 == event2) return -1;
        if (event1 == null) return 0;
        if (event1.getEventId() == event2.getEventId()) return 0;
        if (event1.getEventId() < event2.getEventId()) return -1;
        return 1;
    }
}
