package com.example.parkprjct.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class ReviewRepositoryTest {


    @Autowired
    ReviewRepository reviewRepository;

//    @Test
//    public void name() throws Exception{
//        assertEquals("hello", "hello");
//    }

    @Test
    public void save() throws Exception{
        long pid = 1L;
        long uid = 1L;
//        Review review = new Review("리뷰내용", 3,0);
//        reviewRepository.save(review);
    }
}