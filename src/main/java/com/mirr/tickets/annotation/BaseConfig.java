package com.mirr.tickets.annotation;
import com.mirr.tickets.jdbc.JdbcUserDao;
import com.mirr.tickets.users.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.AbstractApplicationContext;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Configuration
@ComponentScan(basePackages = "com.mirr.tickets")
@EnableAspectJAutoProxy
public class BaseConfig {

    public static void main(String[] args) {

       // AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BaseConfig.class);

        AbstractApplicationContext context = new AnnotationConfigApplicationContext("com.mirr.tickets");
        //GenericDao userDao = (GenericDao) context.getBean("jdbcUserDao");
        JdbcUserDao jdbcUserDao = (JdbcUserDao) context.getBean("userDaoDB");

        User oksana = new User(0, "kseniamirr@gmail.com", "Oksana", "Abramova", LocalDate.of(1985, 03, 16));
        User alex = new User(0, "sunabramov@gmail.com", "Alex", "Abramov", LocalDate.of(1973, 04, 8));
        User ladyGaga = new User(0, "gaga@gmail.com", "Lady", "Gaga", LocalDate.of(1970, 05, 05));

        oksana = jdbcUserDao.add(oksana);
        alex = jdbcUserDao.add(alex);
        ladyGaga = jdbcUserDao.add(ladyGaga);

        System.out.println("Find All");
        Set<User> listUsers = jdbcUserDao.getAll();
        for (User users : listUsers) {
            System.out.println(users);
        }

        System.out.println("Delete user");
        Optional<User> deleteUser = jdbcUserDao.getById(ladyGaga.getUserId());
        jdbcUserDao.delete(deleteUser.orElseGet(() -> {throw new RuntimeException("Last added user is not found");}));

        oksana.setFirsName("Oksana - Updated");

        context.close();
    }
}

