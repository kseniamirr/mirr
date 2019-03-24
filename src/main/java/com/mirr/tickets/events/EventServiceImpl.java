package com.mirr.tickets.events;

import com.mirr.tickets.auditoriums.AuditoriumService;
import com.mirr.tickets.dao.EventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class EventServiceImpl implements EventService {

    @Autowired
    private AuditoriumService auditoriumService;


    @Autowired
    @Qualifier("genericDao")
    EventDao eventDao;


    @Override
    public Seance saveSeance(String eventName, String auditoriumName, LocalDateTime airDate) {
        Event event = getEventByName(eventName).orElseThrow(() -> new IllegalArgumentException("There is no such event is announced"));

        if (! auditoriumService.getByName(auditoriumName).isPresent()) {
            throw new IllegalArgumentException("There is no such auditorium");
        }

        Seance seance = new Seance(event.getEventId(), auditoriumName, airDate);
        return eventDao.saveSeance(seance);
    }

    public static int compareByEventAuditoriumDate(Seance seance1, Seance seance2) {
        if (seance1 == seance2) return 0;
        if (seance1 == null) return -1;
        if (seance1.getEventId() == seance2.getEventId()) {
            if (seance1.getAuditoriumName() == seance2.getAuditoriumName()) {
                if (seance1.getAirDateTime() == seance2.getAirDateTime()) return 0;
                if (seance1.getAirDateTime() == null) return -1;
                return seance1.getAirDateTime().compareTo(seance2.getAirDateTime());
            } else {
                if (seance1.getAuditoriumName() == null) {
                    return -1;
                }
                return seance1.getAuditoriumName().compareTo(seance2.getAuditoriumName());
            }
        } else {
            return seance1.getEventId() < seance2.getEventId() ? -1 : 1;
        }

    }


    @Override
    public Event save(Event event) {
        eventDao.add(event);
        return event;
    }

    @Override
    public void remove(int id) {
        Event event = new Event();
        event.setEventId(id);
        eventDao.delete(event);
    }

    @Override
    public Optional<Event> getById(int id) {
        return eventDao.getById(id);
    }

    @Override
    public Optional<Event> getEventByName(String name) {
        return eventDao.getEventByName(name);
    }


    @Override
    public Set<Event> getAllEvents() {
        return eventDao.getAll();
    }

//    @Override
//    public Seance saveSeance(String eventName, String auditoriumName, LocalDateTime airDate) {
//        Seance seance = new Seance()
//        return eventDao.saveSeance();
//    }

    @Override
    public Event getForDateRange(Date from, Date to) {
        return null;
    }

    @Override
    public Event getNextEvents(Date to) {
        return null;
    }

    @Override
    public void update(Event event, String[] params) {

    }
}




