package com.mirr.tickets.ticket;

import com.mirr.tickets.events.Event;
import com.mirr.tickets.users.User;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketService {

    User getUser();

    Event getEvent();

    LocalDateTime getDateTime();

    long getSeat();

    List<Ticket>getTicketsByUser(User user);

    List<Ticket>getTicketsByEvent(Event event);

   }
