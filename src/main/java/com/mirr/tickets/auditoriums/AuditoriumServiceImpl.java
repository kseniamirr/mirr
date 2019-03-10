package com.mirr.tickets.auditoriums;


import com.mirr.tickets.annotation.DBProperties;
import com.mirr.tickets.dao.AuditoriumDao;

import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.*;


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
