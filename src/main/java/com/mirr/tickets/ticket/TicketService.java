package com.mirr.tickets.ticket;

import com.mirr.tickets.events.EventDto;
import com.mirr.tickets.users.UserDto;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketService {

    UserDto getUser();

    EventDto getEvent();

    LocalDateTime getDateTime();

    long getSeat();

    List<TicketDto>getTicketsByUser(UserDto user);

    List<TicketDto>getTicketsByEvent(EventDto event);

   }
