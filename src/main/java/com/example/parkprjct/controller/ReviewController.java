package com.example.parkprjct.controller;

import com.example.parkprjct.dto.ReviewSaveRequestDto;
import com.example.parkprjct.service.ReviewService;
import com.google.api.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parks/{parkIdx}/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("reviews")
    public

    @PostMapping("")//param?
    public void postReview(@RequestBody ReviewSaveRequestDto reviewSaveRequestDto,
                           Authentication authentication){

        //uIdx와 pIdx어떻게 받아올지
        //reviewService.postReview();
    }

    @DeleteMapping("/{reviewIdx}")//리뷰idx로 해당 리뷰 삭제하기
    public void deleteReview(@PathVariable("reviewIdx") Long rIdx){
        reviewService.deleteReview(rIdx);
    }
}
