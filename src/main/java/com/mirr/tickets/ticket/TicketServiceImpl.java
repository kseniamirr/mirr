package com.mirr.tickets.ticket;

import com.mirr.tickets.events.EventDto;
import com.mirr.tickets.users.UserDto;

import java.time.LocalDateTime;
import java.util.List;

public class TicketServiceImpl implements TicketService {
    @Override
    public UserDto getUser() {
        return null;
    }

    @Override
    public EventDto getEvent() {
        return null;
    }

    @Override
    public LocalDateTime getDateTime() {
        return null;
    }

    @Override
    public long getSeat() {
        return 0;
    }

    @Override
    public List<TicketDto> getTicketsByUser(UserDto user) {
        return null;
    }

    @Override
    public List<TicketDto> getTicketsByEvent(EventDto event) {
        return null;
    }
}
