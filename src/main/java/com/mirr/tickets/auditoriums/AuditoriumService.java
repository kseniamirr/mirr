package com.mirr.tickets.auditoriums;

import java.util.*;


public interface AuditoriumService {

    public static void getPropertyFile() {

    }


    public Set<Auditorium> getAll();

    public Auditorium getByName(String name);
}
