package com.mirr.tickets.auditoriums;

import java.util.*;

public class AuditoriumServiceImpl implements AuditoriumService {

    private static NavigableSet<AuditoriumDto> auditoriumDtoList = new TreeSet<>();


    @Override
    public List<AuditoriumDto> getAll() {
        List<AuditoriumDto> auditoriumDtoList = new ArrayList<>();
        return auditoriumDtoList;
    }

    @Override
    public AuditoriumDto getByName(String name) {
        AuditoriumDto auditoriumDto = new AuditoriumDto();
        auditoriumDto.setName(name);
        AuditoriumDto auditoriumFounded = auditoriumDtoList.ceiling(auditoriumDto);
        return auditoriumFounded;
    }
}
