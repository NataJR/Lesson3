package com.example.geekbrainsdb;

import com.example.geekbrainsdb.model.User;
import com.example.geekbrainsdb.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class GeekbrainsDbApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GeekbrainsDbApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        UserRepo repo = new UserRepo();
        repo.printAllInformation(jdbcTemplate);
        repo.printInformationByAge(jdbcTemplate, 10, 60);
        repo.printMinMaxAge(jdbcTemplate);


        //repo.deleteUser(jdbcTemplate,"Bob");
        repo.addUSer(jdbcTemplate, "Bob 32 bob32@gmail.com");
        repo.addUSer(jdbcTemplate, "Mehdi 100 mehdi@gmail.com");
        repo.printAllInformation(jdbcTemplate);
    }
}
