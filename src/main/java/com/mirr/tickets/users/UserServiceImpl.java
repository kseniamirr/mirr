package com.mirr.tickets.users;

import com.mirr.tickets.dao.GenericDao;
import com.mirr.tickets.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserServiceImpl implements UserService {


    @Autowired
    @Qualifier("userDaoDB")
    public UserDao userDaoImpl;

    @Override
    public User save(User user) {
        return userDaoImpl.add(user);
    }

    @Override
    public void remove(int id) {
        User user = new User();
        user.setUserId(id);
        userDaoImpl.delete(user);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userDaoImpl.getById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userDaoImpl.getUserByEmail(email);
    }

    @Override
    public Set<User> getAll() {
        return userDaoImpl.getAll();
    }

}
