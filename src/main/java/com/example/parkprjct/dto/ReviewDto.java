package com.example.parkprjct.dto;


import com.example.parkprjct.entity.Review;
import com.example.parkprjct.entity.Users;
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
    private int rLikeCnt;
    private String rDesc;
    private Timestamp rDate;

    public ReviewDto(Review review, Users user){
        this.rIdx = review.getRIdx();
        this.uIdx = user.getUIdx();
        this.uNickname = user.getUNickname();
        this.gImg = user.getGImg();
        this.rLikeCnt = review.getRLikeCnt();
        this.rDesc = review.getRDesc();
        this.rDate = review.getRDate();
    }

}
