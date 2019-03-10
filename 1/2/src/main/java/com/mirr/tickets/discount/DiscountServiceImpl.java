package com.mirr.tickets.discount;

import com.mirr.tickets.events.EventDto;
import com.mirr.tickets.users.UserDto;

import java.time.LocalDateTime;

public class DiscountServiceImpl implements DiscountService{

      DiscountServiceDto discountServiceDto;

    @Override
    public byte getDiscount(UserDto user, EventDto event, LocalDateTime airDateTime, long numberOfTickets) {
        //discountServiceDto.
        return 0;
    }
}
