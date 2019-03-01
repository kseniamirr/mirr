package com.mirr.tickets.users;

import com.mirr.tickets.users.UserDto;

import java.util.List;

interface UserService {

    UserDto save(UserDto userDto);


    void remove(int id);


    UserDto getUserById(int id);


    UserDto getUserByEmail(String email);


    List<UserDto> getAll();


}
