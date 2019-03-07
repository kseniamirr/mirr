package com.mirr.tickets.dao;

import com.mirr.tickets.auditoriums.Auditorium;
import com.mirr.tickets.auditoriums.AuditoriumServiceImpl;
import com.mirr.tickets.events.Event;
import lombok.Setter;

import java.util.List;
import java.util.NavigableSet;
import java.util.Optional;
import java.util.TreeSet;

@Setter
public class AuditoriumDao implements  GenericDao<Auditorium> {

    public static NavigableSet<Auditorium> auditoriumList = new TreeSet<>(AuditoriumServiceImpl::compareByName);

    @Override
    public void save(Auditorium auditorium) {

    }

    @Override
    public void remove(Auditorium auditorium) {

    }

    @Override
    public List<Auditorium> getAll() {
        return null;
    }

    @Override
    public Optional<Auditorium> get(Auditorium auditorium) {
        return Optional.empty();
    }

    @Override
    public void update(Auditorium auditorium, String[] params) {

    }

    @Override
    public Event getName() {

        return null;
    }
}
