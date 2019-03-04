package com.mirr.tickets.auditoriums;

import java.util.*;


public interface AuditoriumService {

    public static void getPropertyFile() {

    }


    public Set<AuditoriumDto> getAll();

    public AuditoriumDto getByName(String name);
}
