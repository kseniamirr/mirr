package com.mirr.tickets.discount;

import com.mirr.tickets.events.EventDto;
import com.mirr.tickets.users.UserDto;

import java.time.LocalDateTime;

interface DiscountService {

    TotalDiscount getDiscount(UserDto userDto, EventDto eventDto, LocalDateTime dateTime, int numberOfTickets );
}
