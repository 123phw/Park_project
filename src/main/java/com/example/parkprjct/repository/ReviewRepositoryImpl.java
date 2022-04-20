package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Review;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class ReviewRepositoryImpl extends QuerydslRepositorySupport implements ReviewRepositoryCustom {

    @Autowired
    private JPAQueryFactory queryFactory;
    private ReviewRepository reviewRepository;

    public ReviewRepositoryImpl(){ super(Review.class); }


}
