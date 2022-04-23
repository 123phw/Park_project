package com.example.parkprjct.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ReviewSaveRequestDto {

    private int rRate;
    private String rDesc;
}
