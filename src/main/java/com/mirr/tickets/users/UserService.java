package com.mirr.tickets.users;

import java.util.List;

public interface UserService {

    User save(User user);


    void remove(int id);


    User getUserById(int id);


    User getUserByEmail(String email);


    List<User> getAll();

    void update(User user, String[] params);

}
