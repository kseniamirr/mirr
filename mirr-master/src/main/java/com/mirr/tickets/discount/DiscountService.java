package com.mirr.tickets.discount;

import com.mirr.tickets.events.EventServiceDto;
import com.mirr.tickets.users.UserDto;

import java.time.LocalDateTime;

interface DiscountService {

    TotalDiscount getDiscount(UserDto userDto, EventServiceDto eventServiceDto, LocalDateTime dateTime, int numberOfTickets );
}
