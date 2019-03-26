package com.mirr.tickets.jdbc;
import com.mirr.tickets.dao.GenericDao;
import com.mirr.tickets.users.User;
import com.mirr.tickets.users.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("userDaoDB")
@Qualifier("genericDao")
public class JdbcUserDao implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate jdbcTemplate(){
        return jdbcTemplate;
    }

    @Override
    public User add(User user) {
        if (user == null || user.getEmail() == null) {
            throw new IllegalArgumentException("User or its email is null");
        }
        jdbcTemplate.update("INSERT INTO users (first_name, last_name, email) VALUES (?, ?, ?)", user.getFirsName(), user.getLastName(), user.getEmail());
        user = getUserByEmail(user.getEmail()).orElseThrow(() -> new RuntimeException("added user is not found"));
        System.out.println("User added!");
        return user;
    }

    @Override
    public void delete(User user) {
        jdbcTemplate.update("DELETE from users WHERE user_id = ?", user.getUserId());
        System.out.println("User Deleted!");
    }

    @Override
    public Set<User> getAll() {
        List<User> users = jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper(User.class));
        Set<User> usersSet = new HashSet<>(users);
        return usersSet;
    }

    @Override
    public Optional<User> getById(int id) {
        User user = jdbcTemplate.queryForObject("SELECT * from users WHERE user_id = ?", new Integer[] {id}, new BeanPropertyRowMapper<>(User.class));
        return Optional.of(user);
    }

    @Override
    public void update(User user, String[] params) {
        jdbcTemplate.update("INSERT INTO users SET first_name = ?, last_name = ?, email = ? WHERE user_id = ?",
                user.getFirsName(), user.getLastName(), user.getEmail(), user.getUserId());
        System.out.println("User updated!");

    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        List<User> userList = jdbcTemplate.query("SELECT * from users WHERE email = ? order by user_id", new String[] {email}, new BeanPropertyRowMapper<>(User.class));
        User user = (userList.isEmpty()? null : userList.get(userList.size() - 1));
        return Optional.of(user);
    }
}
