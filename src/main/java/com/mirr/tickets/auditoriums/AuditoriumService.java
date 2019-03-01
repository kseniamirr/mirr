package com.mirr.tickets.auditoriums;

import java.util.List;

interface AuditoriumService {

    List<AuditoriumServiceDto> getAll();

    void getByName(String name);
}
