package com.mirr.tickets.booking;

import com.mirr.tickets.auditoriums.AuditoriumServiceDto;
import com.mirr.tickets.events.EventServiceDto;
import com.mirr.tickets.users.UserDto;

import java.time.LocalDateTime;

public class BookingServiceImpl implements BookingService {
    @Override
    public Price getTicketsPrice(String eventName, LocalDateTime dateTime, int userId, AuditoriumServiceDto numberOfSeats) {
        return null;
    }

    @Override
    public void getPurchasedTicketsForEvent() {

    }
}
