package com.example.parkprjct.entity;

import com.example.parkprjct.dto.ReviewSaveRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_idx", nullable = false)
    private Long rIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_idx", nullable = false)
    private Users uIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "p_idx", nullable = false)
    private Park pIdx;

    @Column(name = "r_desc", length = 1000)
    private String rDesc;

    @Column(name = "r_rate", nullable = false, columnDefinition = "int default '0'")
    private int rRate;

    @Column(name = "r_like_cnt", nullable = false)
    private int rLikeCnt;

    @Column(name = "r_date")
    @CreationTimestamp
    private Timestamp rDate;

    @JsonIgnore
    @OneToMany(mappedBy = "rIdx")
    private List<Good> goods;

    public Review(String rDesc, int rRate, Users uIdx, Park pIdx) {
        this.rDesc = rDesc;
        this.rRate = rRate;
        this.uIdx = uIdx;
        this.pIdx = pIdx;
    }

    public void updateReview(ReviewSaveRequestDto reviewSaveRequestDto){
        this.rRate = reviewSaveRequestDto.getRRate();
        this.rDesc = reviewSaveRequestDto.getRDesc();
    }


}