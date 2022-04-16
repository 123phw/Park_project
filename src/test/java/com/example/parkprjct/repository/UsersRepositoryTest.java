package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class UsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;

//    @Test
//    public void name() throws Exception{
//        assertEquals("hello", "hello");
//    }

    @Test
    public void save() throws Exception{
        Users users = new Users("ababc12", "abd.com", "hw0");
        usersRepository.save(users);
    }
}