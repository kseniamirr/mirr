package com.mirr.tickets.dao;

import com.mirr.tickets.users.User;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
public class UserDao implements GenericDao<User> {

    public static NavigableSet<User> navigableUsers = new TreeSet<>(UserDao::compareById);


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
    public Set<User> getAll() {
        return navigableUsers;
    }


    @Override
    public Optional<User> getById(int id) {
        User user = new User();
        user.setId(id);
        User userEqualIdResult = navigableUsers.ceiling(user);
        if (userEqualIdResult != null && userEqualIdResult.getId() != id) {
            return Optional.empty();
        }
        return Optional.ofNullable(userEqualIdResult);
    }

    public Optional<User> getUserByEmail(String email) {
        User user = new User();
        user.setEmail(email);

        List<User> userList = new ArrayList(navigableUsers);
        Collections.sort(userList, UserDao::compareByEmail);

        int pos = Collections.binarySearch(userList, user, UserDao::compareByEmail);
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
        if (user1.getId() == user2.getId()) return 0;
        if (user1.getId() < user2.getId()) return -1;
        return 1;
    }

    @Override
    public void update(User user, String[] params) {
        user.setLastName(Objects.requireNonNull(params[1], "First name connot be null"));
        user.setLastName(Objects.requireNonNull(params[2], "Last name connot be null"));
        user.setLastName(Objects.requireNonNull(params[3], "Email name connot be null"));

        navigableUsers.add(user);

    }

}
