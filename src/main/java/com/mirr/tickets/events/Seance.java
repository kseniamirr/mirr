package com.mirr.tickets.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
public class Seance {

    private int seanceId;
    private int eventId;
    private String auditoriumName;
    private LocalDate airDateTime;


    public Seance(int id, String auditoriumName, LocalDate airDate) {
    }
}
