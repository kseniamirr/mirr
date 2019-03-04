package com.mirr.tickets.booking;

import com.mirr.tickets.events.EventDto;
import com.mirr.tickets.ticket.TicketDto;
import com.mirr.tickets.users.UserDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

interface BookingService {

    public double getTicketsPrice(EventDto event, LocalDateTime dateTime, UserDto user,
                                  Set<Long> seats);

    public void bookTickets(List<TicketDto> tickets);

    public List<TicketDto> getPurchasedTicketsForEvent(EventDto event, LocalDateTime dateTime);

}
