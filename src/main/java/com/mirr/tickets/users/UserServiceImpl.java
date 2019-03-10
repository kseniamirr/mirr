package com.mirr.tickets.users;

import com.mirr.tickets.dao.UserDao;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
@Setter
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public User save(User user) {
        if (user.getId() == 0) {
            try {
                user.setId(userDao.navigableUsers.last().getId() + 1);
            } catch (NoSuchElementException e) {
                user.setId(0);
            }
        }
        userDao.save(user);
        return user;
    }

    @Override
    public void remove(int id) {
        User user = new User();
        user.setId(id);
        userDao.remove(user);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userDao.getById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public Set<User> getAll() {
        return userDao.getAll();
    }


    @Override
    public void update(User user, String[] params) {

    }
}
