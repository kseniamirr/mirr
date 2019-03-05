package com.mirr.tickets.booking;

import com.mirr.tickets.events.Event;
import com.mirr.tickets.ticket.Ticket;
import com.mirr.tickets.users.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface BookingService {

    public double getTicketsPrice(Event event, LocalDateTime dateTime, User user,
                                  Set<Long> seats);

    public void bookTickets(List<Ticket> tickets);

    public List<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime);

}
