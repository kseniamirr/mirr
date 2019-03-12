package com.mirr.tickets.users;

import com.mirr.tickets.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserServiceImpl implements UserService {


    @Autowired
    public UserDaoImpl userDaoImpl;

    @Override
    public User save(User user) {
        if (user.getUserId() == 0) {
            try {
                user.setUserId(userDaoImpl.navigableUsers.last().getUserId() + 1);
            } catch (NoSuchElementException e) {
                user.setUserId(0);
            }
        }
        userDaoImpl.add(user);
        return user;
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
