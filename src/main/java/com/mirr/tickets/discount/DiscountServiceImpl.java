package com.mirr.tickets.discount;

import com.mirr.tickets.events.EventServiceDto;
import com.mirr.tickets.users.UserDto;

import java.time.LocalDateTime;

public class DiscountServiceImpl implements DiscountService{


    @Override
    public TotalDiscount getDiscount(UserDto userDto, EventServiceDto eventServiceDto, LocalDateTime dateTime, int numberOfTickets) {
        return null;
    }
}