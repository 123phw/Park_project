package com.example.parkprjct.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
//import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "park")
public class Park {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_idx", nullable = false)
    private Long pIdx;

    @Column(name = "p_name", nullable = false)
    private String pName;

    @Column(name = "p_addr")
    private String pAddr;

    @Column(name = "p_img")
    private String pImg;

    @Column(name = "p_area")
    private String pArea;

    @Column(name = "p_site")
    private String pSite;

    @Column(name = "p_desc", length = 1000)
    private String pDesc;

    @Column(name = "p_avg_rate", columnDefinition = "decimal(10,1) default '0.0'")
    private BigDecimal pAvgRate;

    @Column(name = "p_x")
    private BigDecimal pX;
    @Column(name = "p_y")
    private BigDecimal pY;

    @JsonIgnore//Json으로 표현시 제외
    @OneToMany(mappedBy = "pIdx")
    private List<Review> reviews;

    public Park(String pName, String pAddr, String pImg, String pArea, String pSite, String pDesc, BigDecimal pX, BigDecimal pY) {
        this.pName = pName;
        this.pAddr = pAddr;
        this.pImg = pImg;
        this.pArea = pArea;
        this.pSite = pSite;
        this.pDesc = pDesc;
        this.pX = pX;
        this.pY = pY;
        //this.pAvgRate = pAvgRate;
    }

}
