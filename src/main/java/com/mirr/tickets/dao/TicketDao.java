package com.mirr.tickets.dao;

import com.mirr.tickets.ticket.Ticket;

import java.util.NavigableSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class TicketDao implements GenericDao<Ticket> {


    NavigableSet<Ticket> tickets = new TreeSet<>();

    @Override
    public void save(Ticket ticket) {

    }

    @Override
    public void remove(Ticket ticket) {

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