package com.mirr.tickets.dao;

import com.mirr.tickets.events.Event;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface GenericDao<T> {

    void save(T t);

    void remove(T t);

    Set<T> getAll();

    Optional<T> getById(int id);

    void update(T t, String[] params);

}