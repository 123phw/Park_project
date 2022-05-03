package com.example.parkprjct.dto;

import com.example.parkprjct.entity.Park;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class ParkDto {

    private Long pIdx;
    private String pName;
    //private String pAddr;
    private String pImg;
    private String pArea;
    //private String pSite;
    //private String pDesc;
    private BigDecimal pAvgRate;
    private BigDecimal pGX;
    private BigDecimal pGY;
    private BigDecimal pX;
    private BigDecimal pY;

    //request데이터 받을 dto
    public ParkDto(Park park) {
        this.pIdx = park.getPIdx();
        this.pName = park.getPName();
        //this.pAddr = park.getPAddr();
        this.pImg = park.getPImg();
        this.pArea = park.getPArea();
        //this.pSite = park.getPSite();
        //this.pDesc = park.getPDesc();
        this.pAvgRate = park.getPAvgRate();
        this.pGX = park.getPGX();
        this.pGY = park.getPGY();
        this.pX = park.getPX();
        this.pY = park.getPY();
    }
}
