package com.mirr.tickets.discount;

import com.mirr.tickets.events.Event;
import com.mirr.tickets.users.User;

import java.time.LocalDateTime;

public class DiscountServiceImpl implements DiscountService{

      DiscountServiceDto discountServiceDto;

    @Override
    public byte getDiscount(User user, Event event, LocalDateTime airDateTime, long numberOfTickets) {
        //discountServiceDto.
        return 0;
    }
}
