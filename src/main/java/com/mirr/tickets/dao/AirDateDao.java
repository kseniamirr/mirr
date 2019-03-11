package com.mirr.tickets.dao;

import com.mirr.tickets.auditoriums.Auditorium;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class AirDateDao {


    public NavigableSet<LocalDateTime> airDates = new TreeSet<>();

    public NavigableMap<LocalDateTime, Auditorium> auditoriums = new TreeMap<>();


    public boolean assignAuditorium(LocalDateTime dateTime, Auditorium auditorium) {
        if (airDates.contains(dateTime)) {
            auditoriums.put(dateTime, auditorium);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeAuditoriumAssignment(LocalDateTime dateTime) {
        return auditoriums.remove(dateTime) != null;
    }

    public boolean addAirDateTime(LocalDateTime dateTime) {
        return airDates.add(dateTime);
    }

    public boolean addAirDateTime(LocalDateTime dateTime, Auditorium auditorium) {
        boolean result = airDates.add(dateTime);
        if (result) {
            auditoriums.put(dateTime, auditorium);
        }
        return result;
    }

    public boolean removeAirDateTime(LocalDateTime dateTime) {
        boolean result = airDates.remove(dateTime);
        if (result) {
            auditoriums.remove(dateTime);
        }
        return result;
    }

    public boolean airsOnDateTime(LocalDateTime dateTime) {
        return airDates.stream().anyMatch(dt -> dt.equals(dateTime));
    }


    public boolean airsOnDate(LocalDate date) {
        return airDates.stream().anyMatch(dt -> dt.toLocalDate().equals(date));
    }


    public boolean airsOnDates(LocalDate from, LocalDate to) {
        return airDates.stream().anyMatch(dt -> dt.toLocalDate().compareTo(from) >= 0 && dt.toLocalDate().compareTo(to) <= 0);
    }



}
