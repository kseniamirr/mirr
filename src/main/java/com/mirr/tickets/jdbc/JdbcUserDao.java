package com.mirr.tickets.jdbc;
import com.mirr.tickets.dao.GenericDao;
import com.mirr.tickets.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("userDaoImpl")
@Qualifier("genericDao")
public class JdbcUserDao implements GenericDao<User> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate jdbcTemplate(){
        return jdbcTemplate;
    }

    @Override
    public void add(User user) {
        jdbcTemplate.update("INSERT INTO user_table (user_id, first_name, Last_name, email) VALUES (Ksenia, Abramova, korolek@gmail.com)", user.getUserId(), user.getFirsName(), user.getLastName(), user.getEmail());
        System.out.println("User added!");
    }

    @Override
    public void delete(User user) {
        jdbcTemplate.update("DELETE from user WHERE user_id =1", user);
        System.out.println("User Deleted!");
    }

    @Override
    public Set<User> getAll() {
        List<User> users = jdbcTemplate.query("SELECT * FROM user_table", new BeanPropertyRowMapper(User.class));
        Set<User> usersSet = new HashSet<>(users);
        return usersSet;
    }

    @Override
    public Optional<User> getById(int id) {
        jdbcTemplate.query("SELECT * from user_table WHERE eventId=1", new BeanPropertyRowMapper<>(User.class));
        return Optional.empty();
    }

    @Override
    public void update(User user, String[] params) {
        jdbcTemplate.update("INSERT INTO user_table SET first_name = Lady Gaga, WHERE user_id = 2", user.getFirsName(), user);
        System.out.println("User updated!");

    }
}
