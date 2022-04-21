package com.example.parkprjct.service;

import com.example.parkprjct.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

//    public Page<ReviewDto> getReview(ReviewDto reviewDto, Long pIdx, Pageable pageable){
//
//        reviewDto.
//
//    }
//    public void postReview(ReviewSaveRequestDto reviewSave){
//        Review review = new Review(reviewSave.getRDesc(),reviewSave.getRRate());
//        //reviewRepository.save(review);
//    }

    public void deleteReview(Long rIdx){
        reviewRepository.deleteById(rIdx);
    }

}
