package com.mirr.tickets.auditoriums;


import com.mirr.tickets.annotation.DBProperties;
import com.mirr.tickets.dao.AuditoriumDao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.*;


public class AuditoriumServiceImpl implements AuditoriumService {

    @Autowired
    AuditoriumDao auditoriumDao;

    @Autowired
    DBProperties dbProperties;

    @PostConstruct
    public void postConstruct() {
        String[] auditoriumNamesArray = dbProperties.auditoriumNames.split(";");
        String[] auditoriumSeatsNumberArray = dbProperties.auditoriumSeatsNumber.split(";");
        String[] auditoriumVIPSeatsArray = dbProperties.auditoriumVIPSeats.split(";");

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
            auditoriumDao.auditoriumList.add(auditoriumDto);
        }

    }

    @Override
    public Set<Auditorium> getAll() {
        return auditoriumDao.auditoriumList;
    }

    @Override
    public Auditorium getByName(String name) {
        Auditorium auditorium = new Auditorium();
        auditorium.setName(name);
        Auditorium auditoriumFounded = auditoriumDao.auditoriumList.ceiling(auditorium);
        if (auditoriumFounded != null && !auditoriumFounded.getName().equals(name)) {
            return null;
        }
        return auditoriumFounded;
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
