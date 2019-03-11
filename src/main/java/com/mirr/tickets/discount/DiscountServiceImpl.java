package com.mirr.tickets.discount;

import com.mirr.tickets.events.Event;
import com.mirr.tickets.users.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class DiscountServiceImpl implements DiscountService {


    @Override
    public byte getDiscount(User user, Event event, LocalDateTime airDateTime, long numberOfTickets) {
        return 0;
    }
}
