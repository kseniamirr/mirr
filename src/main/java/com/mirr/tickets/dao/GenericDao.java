package com.mirr.tickets.dao;

import java.util.List;
import java.util.Optional;

interface GenericDao<T> {

    void save(T t);

    void remove(T t);

    List<T> getAll();

    Optional<T> get(T t);

    void update(T t, String[] params);
}