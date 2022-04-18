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

    public ReviewSaveRequestDto(int rRate, String rDesc){
        this.rRate = rRate;
        this.rDesc = rDesc;
    }





}
