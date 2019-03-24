package com.mirr.tickets.users;

import com.mirr.tickets.dao.GenericDao;

import java.util.Optional;

public interface UserDao extends GenericDao<User> {

    public Optional<User> getUserByEmail(String email);

}
