package com.mirr.tickets.aspect;

import com.mirr.tickets.events.Event;

import java.util.logging.Logger;

//@Component
public class EventManager {

    private static Logger LOG;



    public Event getEventById(Integer id) {
        System.out.println("Method getEventById() called");
        return getEventById(id);
    }
}
