package com.mirr.tickets.booking;

import com.mirr.tickets.auditoriums.AuditoriumServiceDto;
import com.mirr.tickets.events.EventServiceDto;
import com.mirr.tickets.users.UserDto;

import java.time.LocalDateTime;

interface BookingService {

    Price getTicketsPrice(EventServiceDto eventServiceDto, LocalDateTime dateTime, UserDto userDto, AuditoriumServiceDto numberOfSeats);

    void getPurchasedTicketsForEvent();

}
