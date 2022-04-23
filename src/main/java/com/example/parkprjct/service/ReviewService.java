package com.example.parkprjct.service;

import com.example.parkprjct.dto.ReviewDto;
import com.example.parkprjct.dto.ReviewSaveRequestDto;
import com.example.parkprjct.dto.ReviewSaveResponseDto;
import com.example.parkprjct.entity.Review;
import com.example.parkprjct.entity.Users;
import com.example.parkprjct.repository.ParkRepository;
import com.example.parkprjct.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    private ParkRepository parkRepository;

    public Page<ReviewDto> getReview(Long pIdx, Pageable pageable){

        return reviewRepository.reviewList(pIdx, pageable)
                .map(review -> new ReviewDto(review));
    }
    public ReviewSaveResponseDto postReview(Users users, Long pIdx, ReviewSaveRequestDto reviewSaveDto){

        parkNotFoundException(pIdx);
        //pIdx미발견시 예외

        Review review = new Review(
                reviewSaveDto.getRDesc(),
                reviewSaveDto.getRRate(),
                users,
                parkRepository.getById(pIdx));

        reviewRepository.save(review);
        //리뷰생성

        return new ReviewSaveResponseDto(review);
    }

    public void deleteReview(Long rIdx){
        reviewRepository.deleteById(rIdx);
    }



    private void parkNotFoundException(Long pIdx){
        parkRepository.findById(pIdx)
                .orElseThrow(()-> {
                    throw new UsernameNotFoundException("해당하는 공원이 없습니다.");
                });
    }

}
