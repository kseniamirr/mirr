package com.mirr.tickets.users;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface UserService {

    User save(User user);


    void remove(int id);


    Optional<User> getUserById(int id);


    Optional<User> getUserByEmail(String email);


    Set<User> getAll();

}
