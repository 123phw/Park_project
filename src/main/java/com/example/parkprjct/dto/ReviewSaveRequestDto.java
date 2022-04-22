package com.example.parkprjct.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Data
public class ReviewSaveRequestDto {


    private int rRate;
    private String rDesc;
    Long pIdx;
    Long uIdx;

    public ReviewSaveRequestDto(int rRate, String rDesc, Long pIdx, Long uIdx){
        this.rRate = rRate;
        this.rDesc = rDesc;
        this.pIdx = pIdx;
        this.uIdx = uIdx;

    }





}
