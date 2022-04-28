package com.example.parkprjct.dto;


import com.example.parkprjct.entity.Review;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@Data
public class ReviewDto {

    private Long rIdx;
    private Long uIdx;
    private String uNickname;
    private String gImg;
    private int rRate;
    private int rLikeCnt;
    private String rDesc;
    private Timestamp rDate;

    public ReviewDto(Review review){
        this.rIdx = review.getRIdx();
        this.uIdx = review.getUIdx().getUIdx();
        this.uNickname = review.getUIdx().getUNickname();
        this.gImg = review.getUIdx().getGImg();
        this.rRate = review.getRRate();
        this.rLikeCnt = review.getRLikeCnt();
        this.rDesc = review.getRDesc();
        this.rDate = review.getRDate();
    }

}
