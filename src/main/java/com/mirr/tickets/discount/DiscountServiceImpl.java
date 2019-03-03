package com.mirr.tickets.discount;

import com.mirr.tickets.events.EventDto;
import com.mirr.tickets.users.UserDto;

import java.time.LocalDateTime;

public class DiscountServiceImpl implements DiscountService{


    @Override
    public TotalDiscount getDiscount(UserDto userDto, EventDto eventDto, LocalDateTime dateTime, int numberOfTickets) {
        return null;
    }
}
