package com.mirr.tickets.annotation;

import com.mirr.tickets.dbConfig.JdbcAppConfig;
import com.mirr.tickets.dao.GenericDao;
import com.mirr.tickets.users.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.AbstractApplicationContext;

import java.time.LocalDate;
import java.util.Set;

@Configuration
@ComponentScan(basePackages = "com.mirr.tickets")
@EnableAspectJAutoProxy
public class BaseConfig {

    public static void main(String[] args) {

       // AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BaseConfig.class);

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(JdbcAppConfig.class);
        GenericDao userDao = (GenericDao) context.getBean("genericDao");

        User oksana = new User(1, "kseniamirr@gmail.com", "Oksana", "Abramova", LocalDate.of(1985, 03, 16));
        User alex = new User(2, "sunabramov@gmail.com", "Alex", "Abramov", LocalDate.of(1973, 04, 8));
        User ladyGaga = new User(3, "gaga@gmail.com", "Lady", "Gaga", LocalDate.of(1970, 05, 05));

        userDao.add(oksana);
        userDao.add(alex);
        userDao.add(ladyGaga);

        System.out.println("Find All");
        Set<User> listUsers = userDao.getAll();
        for (User users : listUsers) {
            System.out.println(users);
        }

        System.out.println("Delete user");
        User delete = new User();
        userDao.delete(delete);

        oksana.setFirsName("Oksana - Updated");

        context.close();
    }
}

