package com.example.parkprjct.service;

import com.example.parkprjct.dto.ReviewDto;
import com.example.parkprjct.dto.ReviewSaveRequestDto;
import com.example.parkprjct.dto.ReviewSaveResponseDto;
import com.example.parkprjct.dto.ReviewUpdateResponseDto;
import com.example.parkprjct.entity.Park;
import com.example.parkprjct.entity.Review;
import com.example.parkprjct.entity.Users;
import com.example.parkprjct.exception.ForbiddenException;
import com.example.parkprjct.repository.ParkRepository;
import com.example.parkprjct.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ParkRepository parkRepository;

    @Transactional
    public Page<ReviewDto> getReview(Long pIdx, Pageable pageable){

        Park park = parkNotFoundException(pIdx);
        park.updateAvgRate(parkRepository.updateAvgRate(pIdx));

        return reviewRepository.reviewList(pIdx, pageable)
                .map(review -> new ReviewDto(review));
    }


    @Transactional
    public ReviewSaveResponseDto postReview(Users users, Long pIdx, ReviewSaveRequestDto reviewSaveDto){

        Park park = parkNotFoundException(pIdx);
        //pIdx미발견시 예외

        Review review = new Review(
                reviewSaveDto.getRDesc(),
                reviewSaveDto.getRRate(),
                users,
                parkRepository.getById(pIdx));

        reviewRepository.save(review);
        //리뷰생성
        park.updateAvgRate(parkRepository.updateAvgRate(pIdx));
        //공원 평점 업데이트

        return new ReviewSaveResponseDto(review);
    }

    @Transactional
    public ReviewUpdateResponseDto updateReview(Users user, Long pIdx, Long rIdx, ReviewSaveRequestDto updateReviewDto){

        Park park = parkNotFoundException(pIdx);

        Review review = reviewRepository.findById(rIdx)
                .orElseThrow(()-> {
                    throw new UsernameNotFoundException("해당하는 리뷰가 없습니다.");
                });
        userMatchCheck(user, review);
        //사용자 일치 예외처리

        review.updateReview(updateReviewDto);
        //리뷰수정
        park.updateAvgRate(parkRepository.updateAvgRate(pIdx));
        //공원 평점 업데이트

        return new ReviewUpdateResponseDto(review);
    }

    @Transactional
    public void deleteReview(Users user, Long pIdx, Long rIdx){

        Park park = parkNotFoundException(pIdx);
        riviewNotFoundException(rIdx);

        Review review = reviewRepository.findById(rIdx)
                .orElseThrow(()-> {
                    throw new UsernameNotFoundException("해당하는 리뷰가 없습니다.");
                });

        userMatchCheck(user, review);

        reviewRepository.deleteById(rIdx);
        //ridx에 해당하는 리뷰 삭제
        park.updateAvgRate(parkRepository.updateAvgRate(pIdx));
        //공원 평점 업데이트
    }

    private Park parkNotFoundException(Long pIdx){
        return parkRepository.findById(pIdx)
                .orElseThrow(()-> {
                    throw new UsernameNotFoundException("해당하는 공원이 없습니다.");
                });
    }

    private void riviewNotFoundException(Long rIdx){
        reviewRepository.findById(rIdx)
                .orElseThrow(()->{
                    throw  new UsernameNotFoundException("해당하는 리뷰가 없습니다.");
                });
    }

    private void userMatchCheck(Users user, Review review){
        if(!user.getUIdx().equals(review.getUIdx().getUIdx())){
            throw new ForbiddenException("사용자가 일치하지않습니다");
        }
    }



}
