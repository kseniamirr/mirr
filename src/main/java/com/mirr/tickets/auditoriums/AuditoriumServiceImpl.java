package com.mirr.tickets.auditoriums;


import com.mirr.tickets.dao.AuditoriumDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class AuditoriumServiceImpl implements AuditoriumService {

    @Autowired
    private AuditoriumDao auditoriumDao;


    @Override
    public Set<Auditorium> getAll() {
        return auditoriumDao.getAll();
    }

    @Override
    public Optional<Auditorium> getByName(String name) {
        return auditoriumDao.getByName(name);
    }

    @Override
    public Optional<Auditorium> getById(int id) {
        return auditoriumDao.getById(id);
    }
}
