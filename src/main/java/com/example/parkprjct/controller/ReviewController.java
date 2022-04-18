package com.example.parkprjct.controller;

import com.example.parkprjct.dto.ReviewSaveRequestDto;
import com.example.parkprjct.service.ReviewService;
import com.google.api.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parks/{parkIdx}/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("")//param?
    public void postReview(@RequestBody ReviewSaveRequestDto reviewSaveRequestDto,
                           Authentication authentication){

        //uIdx와 pIdx어떻게 받아올지
        //reviewService.postReview();
    }
}
