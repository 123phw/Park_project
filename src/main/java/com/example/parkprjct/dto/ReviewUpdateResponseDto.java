package com.example.parkprjct.dto;

import com.example.parkprjct.entity.Review;
import lombok.Data;

@Data
public class ReviewUpdateResponseDto {

    private int rRate;
    private String rDesc;

    public ReviewUpdateResponseDto(Review review){
        this.rRate = review.getRRate();
        this.rDesc = review.getRDesc();
    }
}
