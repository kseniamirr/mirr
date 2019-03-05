package com.mirr.tickets.discount;

import com.mirr.tickets.events.Event;
import com.mirr.tickets.users.User;

import java.time.LocalDateTime;

interface DiscountService {

    byte getDiscount(User user, Event event, LocalDateTime airDateTime, long numberOfTickets);
}
