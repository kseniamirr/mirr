package com.mirr.tickets.luckyWinner;

import com.mirr.tickets.events.Event;
import com.mirr.tickets.ticket.Ticket;
import com.mirr.tickets.users.User;

import java.util.Set;

public interface LuckyWinnerService {

    Set<Ticket> getLuckyTickets();

    Set<Ticket> getLuckyTicketsByEvent(Event event);

    Set<Ticket> getLuckyTicketsByUser(User user);
}
