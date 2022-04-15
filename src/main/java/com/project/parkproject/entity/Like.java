package com.project.parkproject.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "likes")
public class Like {//공원좋아요(하트)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "l_idx", nullable = false)
    private Long lIdx;

    @JoinColumn(name = "u_idx", nullable = false)
    @OneToOne
    private Users uIdx;

    @JoinColumn(name = "p_idx", nullable = false)
    @OneToOne
    private Park pIdx;

}