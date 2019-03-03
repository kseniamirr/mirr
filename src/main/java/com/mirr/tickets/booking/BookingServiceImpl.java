package com.mirr.tickets.booking;

import com.mirr.tickets.auditoriums.AuditoriumDto;

import java.time.LocalDateTime;

public class BookingServiceImpl implements BookingService {
    @Override
    public Price getTicketsPrice(String eventName, LocalDateTime dateTime, int userId, AuditoriumDto numberOfSeats) {
        return null;
    }

    @Override
    public void getPurchasedTicketsForEvent() {

    }
}
