package com.mirr.tickets.events;

import com.mirr.tickets.auditoriums.AuditoriumDto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface EventService {

    EventDto save(EventDto eventDto);

    void remove(int id);

    EventDto getById(int id);

    EventDto getEventByName(String name);

    List<EventDto> getAllEvents();

    SeanceDto saveSeance(String eventName, String auditoriumName, LocalDateTime airDate);


    //EventDto saveEventOccurence(int eventId, AuditoriumDto auditoriumId, Date to);

    EventDto getForDateRange(Date from, Date to);

    EventDto getNextEvents(Date to);


}
