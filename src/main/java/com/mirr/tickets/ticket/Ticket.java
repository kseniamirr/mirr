package com.mirr.tickets.ticket;

import com.mirr.tickets.events.Event;
import com.mirr.tickets.users.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Ticket {

    private User user;

    private Event event;

    private LocalDateTime dateTime;

    private long seat;
}
