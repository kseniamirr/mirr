package com.mirr.tickets.dao;

import com.mirr.tickets.events.Event;
import com.mirr.tickets.users.User;
import com.mirr.tickets.users.UserServiceImpl;

import java.util.*;

public class UserDao implements GenericDao<User> {


    public static NavigableSet<User> navigableUsers = new TreeSet<>(UserServiceImpl::compareById);

    public List<User> userList = new ArrayList<>(navigableUsers);

    public List<User> userSearchList = new ArrayList<>(navigableUsers);



    public UserDao() {
        navigableUsers.add(new User(1, "kseniamirr@gmail.com", "Oksana", "Abramova"));
        navigableUsers.add(new User(2, "sun@gmail.com", "Alex", "Abramov"));
    }

    @Override
    public void save(User user) {
        navigableUsers.add(user);
    }

    @Override
    public void remove(User user) {
        navigableUsers.remove(user);
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public Optional<User> get(User user) {
        return Optional.ofNullable(userList.get(user.getId()));
    }

    @Override
    public void update(User user, String[] params) {
        user.setLastName(Objects.requireNonNull(params[1], "First name connot be null"));
        user.setLastName(Objects.requireNonNull(params[2], "Last name connot be null"));
        user.setLastName(Objects.requireNonNull(params[3], "Email name connot be null"));

        navigableUsers.add(user);

    }
}
