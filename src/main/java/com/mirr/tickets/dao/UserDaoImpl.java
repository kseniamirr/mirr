package com.mirr.tickets.dao;

import com.mirr.tickets.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Repository("genericDao")
public class UserDaoImpl implements GenericDao<User> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static NavigableSet<User> navigableUsers = new TreeSet<>(UserDaoImpl::compareById);


    public UserDaoImpl() {
        navigableUsers.add(new User(1, "kseniamirr@gmail.com", "Oksana", "Abramova", LocalDate.of(1985, 03, 16)));
        navigableUsers.add(new User(2, "sun@gmail.com", "Alex", "Abramov", LocalDate.of(1973, 04, 8)));
    }

    @Override
    public void add(User user) {
        navigableUsers.add(user);
    }

    @Override
    public void delete(User user) {
        navigableUsers.remove(user);
    }

    @Override
    public Set<User> getAll() {
        return navigableUsers;
    }


    @Override
    public Optional<User> getById(int id) {
        User user = new User();
        user.setUserId(id);
        User userEqualIdResult = navigableUsers.ceiling(user);
        if (userEqualIdResult != null && userEqualIdResult.getUserId() != id) {
            return Optional.empty();
        }
        return Optional.ofNullable(userEqualIdResult);
    }

    public Optional<User> getUserByEmail(String email) {
        User user = new User();
        user.setEmail(email);

        List<User> userList = new ArrayList(navigableUsers);
        Collections.sort(userList, UserDaoImpl::compareByEmail);

        int pos = Collections.binarySearch(userList, user, UserDaoImpl::compareByEmail);
        return pos != -1 ? Optional.of(userList.get(pos)) : null;
    }

    private static int compareByEmail(User user1, User user2) {
        if (user1 == user2) return 0;
        if (user1 == null) return -1;
        if (user1.getEmail() == user2.getEmail()) return 0;
        if (user1.getEmail() == null) return -1;
        return user1.getEmail().compareTo(user2.getEmail());
    }

    public static int compareById(User user1, User user2) {
        if (user1 == user2) return -1;
        if (user1 == null) return 0;
        if (user1.getUserId() == user2.getUserId()) return 0;
        if (user1.getUserId() < user2.getUserId()) return -1;
        return 1;
    }

    @Override
    public void update(User user, String[] params) {
        user.setLastName(Objects.requireNonNull(params[1], "First eventName connot be null"));
        user.setLastName(Objects.requireNonNull(params[2], "Last eventName connot be null"));
        user.setLastName(Objects.requireNonNull(params[3], "Email eventName connot be null"));

        navigableUsers.add(user);
    }
}
