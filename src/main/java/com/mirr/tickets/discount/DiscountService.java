package com.mirr.tickets.discount;

import com.mirr.tickets.events.EventDto;
import com.mirr.tickets.users.UserDto;

import java.time.LocalDateTime;

interface DiscountService {

    byte getDiscount(UserDto user, EventDto event, LocalDateTime airDateTime, long numberOfTickets);
}
