package com.mirr.tickets.events;

import com.mirr.tickets.users.UserService;
import com.mirr.tickets.users.UserServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class EventServiceImpl implements EventService {

    @Getter
    @Setter
    private UserService userService;


    @Override
    public EventServiceDto save(EventServiceDto eventServiceDto) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void getById(int id) {

    }

    @Override
    public void getUserByName(String email) {

    }

    @Override
    public List<EventServiceDto> getAll() {
        return null;
    }

    @Override
    public EventServiceDto getForDateRange(Date from, Date to) {
        return null;
    }

    @Override
    public EventServiceDto getNextEvents(Date to) {
        return null;
    }
}
