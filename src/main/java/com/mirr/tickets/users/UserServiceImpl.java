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
//Todo: this should only be done if user is adding into collection, i.e. if user id is 0
            int id =
                    sortedSetUsers.last().getId() + 1;
            userDto.setId(id);
//Todo: no add operation into sortedSetUsers
        } catch (NoSuchElementException e) {
//Todo: No explicit initiation of user id attribute (recomended to start counting user if from 1)
//Todo: operation of adding user into collection should be done for all cases
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
