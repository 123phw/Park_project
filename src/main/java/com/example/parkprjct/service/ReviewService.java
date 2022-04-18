package com.example.parkprjct.service;

import com.example.parkprjct.dto.ReviewSaveRequestDto;
import com.example.parkprjct.entity.Review;
import com.example.parkprjct.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

//    public ReviewDto getReview(Long rIdx){
//
//    }
    public void postReview(ReviewSaveRequestDto reviewSave){
        Review review = new Review(reviewSave.getRDesc(),reviewSave.getRRate());
        //reviewRepository.save(review);
    }

}
