package com.example.parkprjct.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewSaveRequestDto {

    private int rRate;
    private String rDesc;
}
