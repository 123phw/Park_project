package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Good;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(value = SpringRunner.class)
@SpringBootTest
public class GoodRepositoryTest {

    @Autowired
    GoodRepository goodRepository;

//    @Test
//    public void name() throws Exception{
//        assertEquals("hello", "hello");
//    }

    @Test
    public void save() throws Exception{
        Good good = new Good();
        goodRepository.save(good);
    }


}