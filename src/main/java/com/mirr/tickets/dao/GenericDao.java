package com.mirr.tickets.dao;

import com.mirr.tickets.events.Event;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {

    void save(T t);

    void remove(T t);

    List<T> getAll();

    Optional<T> get(T t);

    void update(T t, String[] params);

    Event getName();
}