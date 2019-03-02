package com.mirr.tickets.users;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import java.util.TreeSet;

public class UserServiceImpl implements UserService {

    private static SortedSet<UserDto> sortedSetUsers = new TreeSet<>();


    @Override
    public UserDto save(UserDto userDto) {
        try {
            int id =
                    sortedSetUsers.last().getId() + 1;
            userDto.setId(id);
        } catch (NoSuchElementException e) {
            sortedSetUsers.add(userDto);
        }
            return userDto;
        }

    @Override
    public void remove(int id) {

    }

    @Override
    public UserDto getUserById(int id) {
        return null;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }
}
