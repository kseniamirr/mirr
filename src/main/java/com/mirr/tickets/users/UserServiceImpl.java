package com.mirr.tickets.users;

import java.util.*;

public class UserServiceImpl implements UserService {

    private static NavigableSet<UserDto> navigableSetUsers = new TreeSet<>(UserServiceImpl::compareById);

    @Override
    public UserDto save(UserDto userDto) {
        if (userDto.getId() == 0) {
            try {
                userDto.setId(navigableSetUsers.last().getId() + 1);
            } catch (NoSuchElementException e) {
                userDto.setId(0);
            }
        }
        navigableSetUsers.add(userDto);
        return userDto;
    }

    @Override
    public void remove(int id) {
        UserDto userDto = new UserDto();
        userDto.setId(id);
        navigableSetUsers.remove(userDto);
    }

    @Override
    public UserDto getUserById(int id) {
        UserDto userDto = new UserDto();
        userDto.setId(id);
        UserDto userEqualIdResult = navigableSetUsers.ceiling(userDto);
        if (userEqualIdResult != null && userEqualIdResult.getId() != id) {
            return null;
        }
        return userEqualIdResult;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        UserDto userDto = new UserDto();
        userDto.setEmail(email);

        List<UserDto> userSearchList = new ArrayList<>(navigableSetUsers);
        Collections.sort(userSearchList, UserServiceImpl::compareByEmail);

        int pos = Collections.binarySearch(userSearchList, userDto, UserServiceImpl::compareByEmail);
        return userSearchList.get(pos);
    }

    private static int compareByEmail(UserDto userDto1, UserDto userDto2) {
        if (userDto1 == userDto2) return 0;
        if (userDto1 == null) return -1;
        if (userDto1.getEmail() == userDto2.getEmail()) return 0;
        if (userDto1.getEmail() == null) return -1;
        return userDto1.getEmail().compareTo(userDto2.getEmail());
    }

    private static int compareById(UserDto userDto1, UserDto userDto2) {
        if (userDto1 == userDto2) return -1;
        if (userDto1 == null) return 0;
        if (userDto1.getId() == userDto2.getId()) return 0;
        if (userDto1.getId() < userDto2.getId()) return -1;
        return 1;
    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> userDtoList = new ArrayList<>(navigableSetUsers);
        return userDtoList;
    }
}
