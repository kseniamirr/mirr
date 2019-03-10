package com.mirr.tickets.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class SeanceDto {

    private int seanceId;
    private int eventId;
    private String auditoriumName;
    private LocalDateTime airDateTime;

    public SeanceDto(int eventId, String auditoriumName, LocalDateTime airDateTime) {
        this.eventId = eventId;
        this.auditoriumName = auditoriumName;
        this.airDateTime = airDateTime;
    }
}
