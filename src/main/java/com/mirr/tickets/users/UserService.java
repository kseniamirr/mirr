package com.mirr.tickets.users;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    User save(User user);


    void remove(int id);


    Optional<User> getUserById(int id);


    Optional<User> getUserByEmail(String email);


    Set<User> getAll();

    void update(User user, String[] params);

}
