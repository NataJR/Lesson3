package com.example.geekbrainsdb;

import com.example.geekbrainsdb.model.User;
import com.example.geekbrainsdb.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
class GeekbrainsDbApplicationTests {

    @Autowired
    private UserRepository userRepository;



    @Test
    @Transactional
    void contextLoads() {
        User nikolay = new User();
        nikolay.setId(99999);
        nikolay.setName("Kolya");
        nikolay.setEmail("kolya@gmail.ru");

        User stored = userRepository.save(nikolay);
        Assertions.assertNotNull(stored);

        System.out.println(stored);

    }

}
