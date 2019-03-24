package com.mirr.tickets.dao;

import com.mirr.tickets.events.Event;
import com.mirr.tickets.users.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface GenericDao<T> {

    T add(T t);

    void delete(T t);

    Set<T> getAll();

    Optional<T> getById(int id);

    void update(T t, String[] params);
    }