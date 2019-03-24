package com.mirr.tickets.dao;

import com.mirr.tickets.annotation.DBProperties;
import com.mirr.tickets.auditoriums.Auditorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class AuditoriumDao implements  GenericDao<Auditorium> {

    public static NavigableSet<Auditorium> auditoriumSet = new TreeSet<>(AuditoriumDao::compareByName);

    @Override
    public Auditorium add(Auditorium auditorium) {
        throw new UnsupportedOperationException("This operation is not supported for Auditorium");
    }

    @Override
    public void delete(Auditorium auditorium) {
        throw new UnsupportedOperationException("This operation is not supported for Auditorium");
    }

    @Override
    public Set<Auditorium> getAll() {
        return auditoriumSet;
    }

    @Override
    public Optional<Auditorium> getById(int id) {
        return Optional.empty();
    }


    @Override
    public void update(Auditorium auditorium, String[] params) {

    }

    @Autowired
    AuditoriumDao auditoriumDao;

    @Autowired
    DBProperties dbProperties;

    @PostConstruct
    public void postConstruct() {
        String[] auditoriumNamesArray = dbProperties.getAuditoriumNames().split(";");
        String[] auditoriumSeatsNumberArray = dbProperties.getAuditoriumSeatsNumber().split(";");
        String[] auditoriumVIPSeatsArray = dbProperties.getAuditoriumVIPSeats().split(";");

        for (int i = 0; i < auditoriumNamesArray.length; i++) {
            String auditorium = auditoriumNamesArray[i];
            int auditoriumSeatsNumber = 0;
            int[] auditoriumVIPSeats = new int[]{};
            if (auditoriumSeatsNumberArray.length > i) {
                auditoriumSeatsNumber = Integer.valueOf(auditoriumSeatsNumberArray[i]);
            }
            if (auditoriumVIPSeatsArray.length > i) {
                String auditoriumVIPSeatsStr = auditoriumVIPSeatsArray[i];
                String[] auditoriumVIPSeatsArr = auditoriumVIPSeatsStr.split(",");
                auditoriumVIPSeats = new int[auditoriumVIPSeatsArr.length];
                int el = 0;
                for (String vipSeat : auditoriumVIPSeatsArr) {
                    auditoriumVIPSeats[el++] = Integer.valueOf(vipSeat).intValue();
                }
            }
            Auditorium auditoriumDto = new Auditorium(auditorium, auditoriumSeatsNumber, auditoriumVIPSeats);
            auditoriumDao.auditoriumSet.add(auditoriumDto);
        }

    }


    public Optional<Auditorium> getByName(String name) {
        Auditorium auditorium = new Auditorium();
        auditorium.setName(name);
        Auditorium auditoriumFounded = auditoriumDao.auditoriumSet.ceiling(auditorium);
        if (auditoriumFounded != null && !auditoriumFounded.getName().equals(name)) {
            return Optional.empty();
        }
        return Optional.of(auditoriumFounded);
    }

    public static int compareByName(Auditorium auditorium1, Auditorium auditorium2) {
        if (auditorium1 == auditorium2) return 0;
        if (auditorium1 == null) return -1;
        if (auditorium1.getName() == auditorium2.getName()) return 0;
        if (auditorium1.getName() == null) return -1;
        return auditorium1.getName().compareTo(auditorium2.getName());
    }

    public long countVipSeats(Collection<Long> seats) {
        Set<Long> vipSeats = Collections.emptySet();
        return seats.stream().filter(seat -> vipSeats.contains(seat)).count();
    }
}
