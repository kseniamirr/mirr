package com.mirr.tickets.ticket;

import com.mirr.tickets.events.EventDto;
import com.mirr.tickets.events.EventService;
import com.mirr.tickets.users.UserDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TicketServiceImpl implements TicketService {

    TicketService ticketService;

    @Override
    public UserDto getUser() {
        return null;
    }

    @Override
    public EventDto getEvent() {
        EventDto eventDto = new EventDto();
        eventDto.getName();
        return eventDto;
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
        List<TicketDto> ticketDtoList = new ArrayList<>();
        return ticketDtoList.stream().filter(ticketDto -> ticketDto.getEvent().equals(event)).collect(Collectors.toList());

    }
}
