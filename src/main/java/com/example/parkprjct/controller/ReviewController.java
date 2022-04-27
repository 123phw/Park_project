package com.example.parkprjct.controller;

import com.example.parkprjct.dto.ReviewDto;
import com.example.parkprjct.dto.ReviewSaveRequestDto;
import com.example.parkprjct.entity.Users;
import com.example.parkprjct.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parks/{parkIdx}/reviews")
@Slf4j
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("")//pIdx에 해당하는 공원리뷰 조회
    public Page<ReviewDto> getReview(@PathVariable(value = "parkIdx") Long pIdx,
                                     Pageable pageable){
        return reviewService.getReview(pIdx, pageable);
    }//리뷰조회 - https://parkproj.herokuapp.com/parks/3(공원idx)/reviews

    @PostMapping("")//pIdx값에 해당하는 공원리뷰 등록
    public void postReview(@PathVariable("parkIdx") Long pIdx,
                           @RequestBody ReviewSaveRequestDto reviewSaveRequestDto,
                           Authentication authentication){

        Users users = (Users) authentication.getPrincipal();
        reviewService.postReview(users, pIdx, reviewSaveRequestDto);
    }//리뷰등록 - https://parkproj.herokuapp.com/parks/3(공원idx)/reviews

    @PatchMapping("/{reviewId}")//ridx로 해당하는 사용자의 리뷰 수정
    public void updateReview(@PathVariable("parkIdx") Long pIdx,
                             @PathVariable("reviewId") Long rIdx,
                             @RequestBody ReviewSaveRequestDto updateReviewDto,
                             Authentication authentication){

        Users user = (Users) authentication.getPrincipal();
        reviewService.updateReview(user, pIdx, rIdx, updateReviewDto);
    }//리뷰수정 - https://parkproj.herokuapp.com/parks/3(공원idx)/reviews/4(리뷰idx)

    @DeleteMapping("/{reviewId}")//ridx로 해당 리뷰 삭제하기
    public void deleteReview(@PathVariable("parkIdx") Long pIdx,
                             @PathVariable("reviewId") Long rIdx,
                             Authentication authentication){

        Users user = (Users) authentication.getPrincipal();
        reviewService.deleteReview(user, pIdx, rIdx);
    }//리뷰삭제 - https://parkproj.herokuapp.com/parks/3(공원idx)/reviews/4(리뷰idx)
}
