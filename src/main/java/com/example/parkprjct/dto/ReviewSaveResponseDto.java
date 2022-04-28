package com.example.parkprjct.dto;

import com.example.parkprjct.entity.Review;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ReviewSaveResponseDto {

    private int rRate;
    private String rDesc;
    private Long pIdx;
    private Long uIdx;

    public ReviewSaveResponseDto(Review review){
        this.rDesc = review.getRDesc();
        this.rRate = review.getRRate();
        this.uIdx = review.getUIdx().getUIdx();
        this.pIdx = review.getPIdx().getPIdx();

    }
}
