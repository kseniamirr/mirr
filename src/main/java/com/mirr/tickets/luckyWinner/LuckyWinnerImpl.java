package com.mirr.tickets.luckyWinner;

import com.mirr.tickets.events.Event;
import com.mirr.tickets.ticket.Ticket;
import com.mirr.tickets.users.User;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class LuckyWinnerImpl implements LuckyWinnerService{
    @Override
    public Set<Ticket> getLuckyTickets() {
        return null;
    }

    @Override
    public Set<Ticket> getLuckyTicketsByEvent(Event event) {
        return null;
    }

    @Override
    public Set<Ticket> getLuckyTicketsByUser(User user) {
        return null;
    }
}
