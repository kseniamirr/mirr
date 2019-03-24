package com.mirr.tickets.dao;

import com.mirr.tickets.ticket.Ticket;
import java.util.NavigableSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class TicketDao implements GenericDao<Ticket> {


    NavigableSet<Ticket> tickets = new TreeSet<>();

    @Override
    public Ticket add(Ticket ticket) {
        return null;
    }

    @Override
    public void delete(Ticket ticket) {

    }

    @Override
    public Set<Ticket> getAll() {
        return null;
    }

    @Override
    public Optional<Ticket> getById(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Ticket ticket, String[] params) {

    }
}
