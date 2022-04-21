package com.example.parkprjct.controller;

import com.example.parkprjct.dto.ReviewDto;
import com.example.parkprjct.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parks/{parkIdx}/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("reviews")//pIdx에 해당하는 리뷰 조회
    public Page<ReviewDto> getReview(@PathVariable(value = "parkIdx") Long pIdx,
                                     Pageable pageable){
        return reviewService.getReview(pIdx, pageable);
    }

//    @PostMapping("")//
//    public void postReview(@PathVariable(value = "parkIdx") Long pIdx,
//            @RequestBody ReviewSaveRequestDto reviewSaveRequestDto){
//
//        reviewService.postReview();
//    }

    @DeleteMapping("/{reviewIdx}")//리뷰idx로 해당 리뷰 삭제하기
    public void deleteReview(@PathVariable("reviewIdx") Long rIdx){
        reviewService.deleteReview(rIdx);
    }
}