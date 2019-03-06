package com.mirr.tickets.users;

import com.mirr.tickets.dao.UserDao;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
@Setter
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public User save(User user) {
        if (user.getId() == 0) {
            try {
                user.setId(userDao.navigableUsers.last().getId() + 1);
            } catch (NoSuchElementException e) {
                user.setId(0);
            }
        }
        userDao.save(user);
        return user;
    }

    @Override
    public void remove(int id) {
        User user = new User();
        user.setId(id);
        userDao.remove(user);
    }

    @Override
    public User getUserById(int id) {
        User user = new User();
        user.setId(id);
        User userEqualIdResult = userDao.navigableUsers.ceiling(user);
        if (userEqualIdResult != null && userEqualIdResult.getId() != id) {
            return null;
        }
        return userEqualIdResult;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = new User();
        user.setEmail(email);


        Collections.sort(userDao.userSearchList, UserServiceImpl::compareByEmail);

        int pos = Collections.binarySearch(userDao.userSearchList, user, UserServiceImpl::compareByEmail);
        return userDao.userSearchList.get(pos);
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
    public List<User> getAll() {
        return userDao.userList;
    }

    @Override
    public void update(User user, String[] params) {

    }
}
