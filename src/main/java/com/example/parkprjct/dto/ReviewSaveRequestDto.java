package com.example.parkprjct.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ReviewSaveRequestDto {

    @JsonProperty("rRate")
    private int rRate;

    @JsonProperty("rDesc")
    private String rDesc;
}
