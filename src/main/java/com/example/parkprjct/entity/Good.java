package com.example.parkprjct.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "good")
public class Good {//리뷰좋아요

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "g_idx")
    private Long gIdx;

    @JoinColumn(name = "u_idx")
    @OneToOne
    private Users uIdx;

    @JoinColumn(name = "r_idx")
    @ManyToOne
    private Review rIdx;
}
