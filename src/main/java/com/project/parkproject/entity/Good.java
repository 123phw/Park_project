package com.project.parkproject.entity;

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
    @Column(name = "g_idx", nullable = false)
    private Long gIdx;

    @JoinColumn(name = "u_idx", nullable = false)
    @OneToOne
    private Users uIdx;

    @JoinColumn(name = "r_idx", nullable = false)
    @ManyToOne
    private Review rIdx;
}