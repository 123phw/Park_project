package com.example.parkprjct.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(value = SpringRunner.class)
@SpringBootTest
public class ReviewRepositoryTest {


    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    ParkRepository parkRepository;
    @Autowired
    UsersRepository usersRepository;


//    @Test
//    public void name() throws Exception{
//        assertEquals("hello", "hello");
//    }

//    @Test
//    public void save() throws Exception {
//
//        Long uidx = 1L;
//        Long pidx = 1L;
//        String a = "좋아요";
//        int rate = 4;
//        Users user = usersRepository.getById(uidx);
//        Park park = parkRepository.getById(pidx);
//
//        Review review = new Review(a, rate, user, park);
//
//        reviewRepository.save(review);
//    }
}