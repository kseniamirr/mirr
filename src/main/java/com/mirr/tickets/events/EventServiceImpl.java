package com.mirr.tickets.events;

import com.mirr.tickets.auditoriums.Auditorium;
import com.mirr.tickets.auditoriums.AuditoriumService;
import com.mirr.tickets.dao.EventDao;
import com.mirr.tickets.users.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class EventServiceImpl implements EventService {

    @Autowired
    private AuditoriumService auditoriumService;


    @Autowired
    EventDao eventDao;


    public SeanceDto saveSeance(String eventName, String auditoriumName, LocalDateTime airDate) {
        Event event = getEventByName(eventName).orElseThrow(() -> new IllegalArgumentException("There is no such event is announced"));

        if (! auditoriumService.getByName(auditoriumName).isPresent()) {
            throw new IllegalArgumentException("There is no such auditorium");
        }


        SeanceDto seanceDto = new SeanceDto(event.getId(), auditoriumName, airDate);
        return eventDao.saveSeance(seanceDto);
    }

    public static int compareByEventAuditoriumDate(SeanceDto seanceDto1, SeanceDto seanceDto2) {
        if (seanceDto1 == seanceDto2) return 0;
        if (seanceDto1 == null) return -1;
        if (seanceDto1.getEventId() == seanceDto2.getEventId()) {
            if (seanceDto1.getAuditoriumName() == seanceDto2.getAuditoriumName()) {
                if (seanceDto1.getAirDateTime() == seanceDto2.getAirDateTime()) return 0;
                if (seanceDto1.getAirDateTime() == null) return -1;
                return seanceDto1.getAirDateTime().compareTo(seanceDto2.getAirDateTime());
            } else {
                if (seanceDto1.getAuditoriumName() == null) {
                    return -1;
                }
                return seanceDto1.getAuditoriumName().compareTo(seanceDto2.getAuditoriumName());
            }
        } else {
            return seanceDto1.getEventId() < seanceDto2.getEventId() ? -1 : 1;
        }

    }


    @Override
    public Event save(Event event) {
        eventDao.save(event);
        return event;
    }

    @Override
    public void remove(int id) {
        Event event = new Event();
        event.setId(id);
        eventDao.remove(event);
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


// SAN: unused methods
    /*
    public boolean assignAuditorium(LocalDateTime dateTime, Auditorium auditorium) {
        if (eventDao.airDates.contains(dateTime)) {
            eventDao.auditoriums.put(dateTime, auditorium);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeAuditoriumAssignment(LocalDateTime dateTime) {
        return eventDao.auditoriums.remove(dateTime) != null;
    }

    public boolean addAirDateTime(LocalDateTime dateTime) {
        return eventDao.airDates.add(dateTime);
    }

    public boolean addAirDateTime(LocalDateTime dateTime, Auditorium auditorium) {
        boolean result = eventDao.airDates.add(dateTime);
        if (result) {
            eventDao.auditoriums.put(dateTime, auditorium);
        }
        return result;
    }

    public boolean removeAirDateTime(LocalDateTime dateTime) {
        boolean result = eventDao.airDates.remove(dateTime);
        if (result) {
            eventDao.auditoriums.remove(dateTime);
        }
        return result;
    }

    public boolean airsOnDateTime(LocalDateTime dateTime) {
        return eventDao.airDates.stream().anyMatch(dt -> dt.equals(dateTime));
    }


    public boolean airsOnDate(LocalDate date) {
        return eventDao.airDates.stream().anyMatch(dt -> dt.toLocalDate().equals(date));
    }


    public boolean airsOnDates(LocalDate from, LocalDate to) {
        return eventDao.airDates.stream().anyMatch(dt -> dt.toLocalDate().compareTo(from) >= 0 && dt.toLocalDate().compareTo(to) <= 0);
    }
*/

}




