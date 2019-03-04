package com.mirr.tickets.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class SeanceDto {

    private int seanceId;
    private int eventId;
    private String auditoriumName;
    private LocalDateTime airDateTime;

}
