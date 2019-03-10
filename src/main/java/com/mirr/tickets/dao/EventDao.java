package com.mirr.tickets.dao;

import com.mirr.tickets.events.Event;
import com.mirr.tickets.events.EventServiceImpl;
import com.mirr.tickets.events.SeanceDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
//        ("eventDao")
//@Qualifier("eventDao")
public interface EventDao extends GenericDao<Event> {

    Optional<Event> getEventByName(String name);

    SeanceDto saveSeance(SeanceDto seanceDto);
}
