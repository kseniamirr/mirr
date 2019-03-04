package com.mirr.tickets.auditoriums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditoriumDto {

    private String name;
    private int numberOfSeats;
    private int[] vipSeats;

    @Override
    public String toString() {
        return "AuditoriumDto{" +
                "name='" + name + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", vipSeats=" + Arrays.toString(vipSeats) +
                '}';
    }
}
