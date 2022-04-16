package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Park;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class ParkRepositoryTest {


    @Autowired
    ParkRepository parkRepository;

    @Test
    public void save() throws Exception{
        Park park = new Park("서울숲공원", "서울시 성동구","dkjfwo.jpg", "성동구","httt://www...", "공원설명", 0.0, 0.0f,0.0f );
        parkRepository.save(park);
    }

}