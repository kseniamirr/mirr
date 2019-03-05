package com.mirr.tickets.events;

import com.mirr.tickets.auditoriums.Auditorium;
import com.mirr.tickets.auditoriums.AuditoriumService;
import com.mirr.tickets.dao.EventDao;
import com.mirr.tickets.users.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public class EventServiceImpl implements EventService {

    @Setter
    private AuditoriumService auditoriumService;


    @Autowired
    EventDao eventDao;


    public SeanceDto saveSeance(String eventName, String auditoriumName, LocalDateTime airDate) {
        Event event = getEventByName(eventName);
        if (event == null) {
            throw new IllegalArgumentException("There is no such event is announced");
        }

        Auditorium auditorium = auditoriumService.getByName(auditoriumName);
        if (auditorium == null) {
            throw new IllegalArgumentException("There is no such auditorium");
        }

        int seanceId;
        try {
            seanceId = eventDao.seanceDtoSet.last().getSeanceId() + 1;
        } catch (NoSuchElementException e) {
            seanceId = 1;
        }

        SeanceDto seanceDto = new SeanceDto(seanceId, event.getId(), auditoriumName, airDate);
        seanceDto.setSeanceId(seanceId);
        eventDao.seanceDtoSet.add(seanceDto);
        return seanceDto;
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
        eventDao.remove(id);
    }

    @Override
    public Optional<Event> getById(int id) {
        Optional<Event> eventById = eventDao.eventList.stream().filter(event -> event.getId() == id).findFirst();
        {
            if (eventById.isPresent()) ;
        }
        return eventById;
    }

//    @Override
//    public Event getById(int id) {
//        Event event = new Event();
//        event.setId(id);
//        Event eventIdResult = eventsSet.ceiling(event);
//        if (eventIdResult != null && eventIdResult.getId() != id) {
//            return null;
//        }
//        return eventIdResult;
//    }

    @Override
    public Event getEventByName(String name) {
        Event event = new Event();
        event.setName(name);


        Collections.sort(eventDao.eventList, EventServiceImpl::compareByName);

        int pos = Collections.binarySearch(eventDao.eventList, event, EventServiceImpl::compareByName);
        return eventDao.eventList.get(pos);
    }

    public static int compareByName(Event event1, Event event2) {
        if (event1 == event2) return 0;
        if (event1 == null) return -1;
        if (event1.getName() == event2.getName()) return 0;
        if (event1.getName() == null) return -1;
        return event1.getName().compareTo(event2.getName());
    }

    private static int compareById(User user1, User user2) {
        if (user1 == user2) return -1;
        if (user1 == null) return 0;
        if (user1.getId() == user2.getId()) return 0;
        if (user1.getId() < user2.getId()) return -1;
        return 1;
    }


    @Override
    public List<Event> getAllEvents() {
        return eventDao.eventList;
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

}




