package com.mirr.tickets.booking;

import com.mirr.tickets.auditoriums.AuditoriumDto;

import java.time.LocalDateTime;

interface BookingService {

    Price getTicketsPrice(String eventName, LocalDateTime dateTime, int userId, AuditoriumDto numberOfSeats);

    void getPurchasedTicketsForEvent();

}
