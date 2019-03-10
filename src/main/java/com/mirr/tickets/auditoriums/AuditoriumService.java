package com.mirr.tickets.auditoriums;

import java.util.*;


public interface AuditoriumService {

    Set<Auditorium> getAll();

    Optional<Auditorium> getByName(String name);

    Optional<Auditorium> getById(int id);

}