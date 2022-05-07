package com.example.parkprjct.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SignupDTO {
    @JsonProperty("uNickname")
    private String uNickname;
    @JsonProperty("gImg")
    private String gImg;
}