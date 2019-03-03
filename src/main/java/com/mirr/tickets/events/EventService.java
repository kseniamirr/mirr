package com.mirr.tickets.events;

import com.mirr.tickets.auditoriums.AuditoriumDto;

import java.util.Date;
import java.util.List;

public interface EventService {

    EventDto save(EventDto eventDto);

    void remove(int id);

    EventDto getById(int id);

    EventDto getEventByName(String email);

    List<EventDto> getAll();


    EventDto saveEventOccurence(int eventId, AuditoriumDto auditoriumId, Date to);

    EventDto getForDateRange(Date from, Date to);

    EventDto getNextEvents(Date to);
}
