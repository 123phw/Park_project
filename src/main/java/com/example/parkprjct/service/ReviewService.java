package com.example.parkprjct.service;

import com.example.parkprjct.dto.ReviewDto;
import com.example.parkprjct.dto.ReviewSaveRequestDto;
import com.example.parkprjct.entity.Review;
import com.example.parkprjct.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Page<ReviewDto> getReview(Long pIdx, Pageable pageable){

        return reviewRepository.reviewList(pIdx, pageable)
                .map(review -> new ReviewDto(review));
    }
    public void postReview(ReviewSaveRequestDto reviewSave){
        Review review = new Review(reviewSave.getRDesc(),reviewSave.getRRate());
        //reviewRepository.save(review);
    }

    public void deleteReview(Long rIdx){
        reviewRepository.deleteById(rIdx);
    }

}
