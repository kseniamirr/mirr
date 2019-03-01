package com.mirr.tickets.events;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public interface EventService {

    EventServiceDto save(EventServiceDto eventServiceDto);

    void remove(int id);

    void getById(int id);

    void getUserByName(String email);

    List<EventServiceDto> getAll();

    EventServiceDto getForDateRange(Date from, Date to);

    EventServiceDto getNextEvents(Date to);
}
