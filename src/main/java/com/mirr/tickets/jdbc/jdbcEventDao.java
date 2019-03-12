package com.mirr.tickets.jdbc;

import com.mirr.tickets.dao.GenericDao;
import com.mirr.tickets.events.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Qualifier("genericDao")
public class jdbcEventDao implements GenericDao<Event> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate jdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public void add(Event event) {
        jdbcTemplate.update("INSERT INTO event_table (event_id, eventName, base_price, event_raiting) VALUES (1, Born a star, 95,00, HIGH)", event.getEventId(), event.getEventName(), event.getBasePrice(), event.getEventRating());
        System.out.println("Event added!");

    }

    @Override
    public void delete(Event event) {
        jdbcTemplate.update("DELETE from event_table WHERE event_id = 1");
    }

    @Override
    public Set<Event> getAll() {
        List<Event> events = jdbcTemplate.query("SELECT * from event_table", new BeanPropertyRowMapper(Event.class));
        Set<Event> eventList = new TreeSet<>(events);
        return eventList;
    }

    @Override
    public Optional<Event> getById(int id) {
        List<Event> eventById = jdbcTemplate.query("SELECT * from event_table WHERE eventId=1", new BeanPropertyRowMapper<>(Event.class));
        //Optional<Event> optionalEvent = new Optional<Event>(eventById);
        return Optional.empty();
    }

    @Override
    public void update(Event event, String[] params) {
        jdbcTemplate.update("INSERT INTO event_table SET eventName WHERE event_id = 2", event.getEventName(), event);
    }
}
