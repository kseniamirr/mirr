package com.mirr.tickets.auditoriums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditoriumDto {

    String name;
    int numberOfSeats;
    int[] vipSeats;

    @Override
    public String toString() {
        return "AuditoriumDto{" +
                "name='" + name + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", vipSeats=" + Arrays.toString(vipSeats) +
                '}';
    }
}
