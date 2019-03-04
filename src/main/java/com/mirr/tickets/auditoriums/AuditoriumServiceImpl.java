package com.mirr.tickets.auditoriums;

import com.mirr.tickets.events.EventDto;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.*;

public class AuditoriumServiceImpl implements AuditoriumService {

    private static NavigableSet<AuditoriumDto> auditoriumDtoList = new TreeSet<>(AuditoriumServiceImpl::compareByName);

    @Setter
    private String auditoriumNames;

    @Setter
    private String auditoriumSeatsNumber;

    @Setter
    private String auditoriumVIPSeats;

    @PostConstruct
    public void postConstruct() {
        String[] auditoriumNamesArray = auditoriumNames.split(";");
        String[] auditoriumSeatsNumberArray = auditoriumSeatsNumber.split(";");
        String[] auditoriumVIPSeatsArray = auditoriumVIPSeats.split(";");

        for (int i = 0; i < auditoriumNamesArray.length; i++) {
            String auditorium = auditoriumNamesArray[i];
            int auditoriumSeatsNumber = 0;
            int[] auditoriumVIPSeats = new int[] {};
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
            AuditoriumDto auditoriumDto = new AuditoriumDto(auditorium, auditoriumSeatsNumber, auditoriumVIPSeats);
            auditoriumDtoList.add(auditoriumDto);
        }

    }

    @Override
    public Set<AuditoriumDto> getAll() {
        return auditoriumDtoList;
    }

    @Override
    public AuditoriumDto getByName(String name) {
        AuditoriumDto auditoriumDto = new AuditoriumDto();
        auditoriumDto.setName(name);
        AuditoriumDto auditoriumFounded = auditoriumDtoList.ceiling(auditoriumDto);
        if (auditoriumFounded != null && auditoriumFounded.getName().equals(name)) {
            return null;
        }
        return auditoriumFounded;
    }

    private static int compareByName(AuditoriumDto auditoriumDto1, AuditoriumDto auditoriumDto2) {
        if (auditoriumDto1 == auditoriumDto2) return 0;
        if (auditoriumDto1 == null) return -1;
        if (auditoriumDto1.getName() == auditoriumDto2.getName()) return 0;
        if (auditoriumDto1.getName() == null) return -1;
        return auditoriumDto1.getName().compareTo(auditoriumDto2.getName());
    }

    public long countVipSeats(Collection<Long> seats) {
        Set<Long> vipSeats = Collections.emptySet();
        return seats.stream().filter(seat -> vipSeats.contains(seat)).count();
    }
}
