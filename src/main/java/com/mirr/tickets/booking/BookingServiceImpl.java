package com.mirr.tickets.booking;

import com.mirr.tickets.annotation.Log;
import com.mirr.tickets.events.Event;
import com.mirr.tickets.ticket.Ticket;
import com.mirr.tickets.ticket.TicketService;
import com.mirr.tickets.users.User;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {


    TicketService ticketService;

    @Log
    private Logger logger;

    @Override
    public double getTicketsPrice(Event event, LocalDateTime dateTime, User user, Set<Long> seats) {
        return ticketService.getTicketsByEvent(event).stream().filter(ticket -> ticket.getDateTime().equals(dateTime)).filter(ticket -> ticket.getUser().equals(user)).filter(ticket -> seats.contains(ticket.getSeat())).mapToDouble(ticket -> ticket.getEvent().getBasePrice()).sum();

    }

    @Override
    /**
     * * Books tickets in internal system. If user is not
     *      * <code>null</code> in a ticket then booked tickets are saved with it
     */
    public void bookTickets(List<Ticket> tickets) {


    }

    /**
     * * Getting all purchased tickets for event on specific air date and time
     * @param event
     * @param dateTime
     * @return list of all purchased tickets
     */
    @Override
    public List<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime) {
        return ticketService.getTicketsByEvent(event).stream().filter(ticket -> ticket.getDateTime().equals(dateTime)).collect(Collectors.toList());
    }
}

