package com.mirr.tickets.events;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Seance {

    private int seanceId;
    private int eventId;
    private String auditoriumName;
    private LocalDateTime airDateTime;


    public Seance(int eventId, String auditoriumName, LocalDateTime airDateTime) {
        this.eventId = eventId;
        this.auditoriumName = auditoriumName;
        this.airDateTime = airDateTime;
    }
}
