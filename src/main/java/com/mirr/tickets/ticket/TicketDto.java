package com.mirr.tickets.ticket;

import com.mirr.tickets.events.EventDto;
import com.mirr.tickets.users.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class TicketDto {
    private UserDto user;

    private EventDto event;

    private LocalDateTime dateTime;

    private long seat;
}
