package com.example.parkprjct.entity;

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
    @JoinColumn(name = "u_idx")
    private Users uIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "p_idx")
    private Park pIdx;

    @Column(name = "r_desc")
    private String rDesc;

    @Column(name = "r_rate")
    private int rRate;

    @Column(name = "r_like_cnt")
    private int rLikeCnt;

    @Column(name = "r_date")
    @CreationTimestamp
    private Timestamp rDate;

    @JsonIgnore
    @OneToMany(mappedBy = "rIdx")
    private List<Good> goods;

    public Review(String rDesc, int rRate, int rLikeCnt) {
        this.rDesc = rDesc;
        this.rRate = rRate;
        this.rLikeCnt = rLikeCnt;
    }

}
