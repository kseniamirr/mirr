package com.mirr.tickets.ticket;

import com.mirr.tickets.events.Event;
import com.mirr.tickets.users.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TicketServiceImpl implements TicketService {

    TicketService ticketService;

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public Event getEvent() {
        Event event = new Event();
        event.getName();
        return event;
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
    public List<Ticket> getTicketsByUser(User user) {
        return null;
    }

    @Override
    public List<Ticket> getTicketsByEvent(Event event) {
        List<Ticket> ticketList = new ArrayList<>();
        return ticketList.stream().filter(ticket -> ticket.getEvent().equals(event)).collect(Collectors.toList());

    }
}
