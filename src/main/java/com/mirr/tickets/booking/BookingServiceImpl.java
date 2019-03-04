package com.mirr.tickets.booking;

import com.mirr.tickets.events.EventDto;
import com.mirr.tickets.ticket.TicketDto;
import com.mirr.tickets.ticket.TicketService;
import com.mirr.tickets.users.UserDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {


    TicketService ticketService;

    @Override
    public double getTicketsPrice(EventDto event, LocalDateTime dateTime, UserDto user, Set<Long> seats) {
        return ticketService.getTicketsByEvent(event).stream().filter(ticketDto -> ticketDto.getDateTime().equals(dateTime)).filter(ticketDto -> ticketDto.getUser().equals(user)).filter(ticketDto -> seats.contains(ticketDto.getSeat())).mapToDouble(ticketDto -> ticketDto.getEvent().getBasePrice()).sum();

    }

    @Override
    /**
     * * Books tickets in internal system. If user is not
     *      * <code>null</code> in a ticket then booked tickets are saved with it
     */
    public void bookTickets(List<TicketDto> tickets) {


    }

    /**
     * * Getting all purchased tickets for event on specific air date and time
     * @param event
     * @param dateTime
     * @return list of all purchased tickets
     */
    @Override
    public List<TicketDto> getPurchasedTicketsForEvent(EventDto event, LocalDateTime dateTime) {
        return ticketService.getTicketsByEvent(event).stream().filter(ticketDto -> ticketDto.getDateTime().equals(dateTime)).collect(Collectors.toList());
    }
}

