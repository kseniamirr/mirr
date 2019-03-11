package com.mirr.tickets.dao;

import com.mirr.tickets.events.Event;
import com.mirr.tickets.events.Seance;
import org.springframework.stereotype.Component;

import java.util.*;

@Component

public interface EventDao extends GenericDao<Event> {

    Optional<Event> getEventByName(String name);

    Seance saveSeance(Seance seance);
}
