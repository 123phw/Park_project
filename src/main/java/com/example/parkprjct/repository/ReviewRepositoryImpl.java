package com.example.parkprjct.repository;


import com.example.parkprjct.entity.Review;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.example.parkprjct.entity.QReview.review;

public class ReviewRepositoryImpl extends QuerydslRepositorySupport implements ReviewRepositoryCustom {

    @Autowired
    private JPAQueryFactory queryFactory;
    private ReviewRepository reviewRepository;

    public ReviewRepositoryImpl(){ super(Review.class); }

    @Override
    public Page<Review> reviewList(Long pIdx, Pageable pageable){

//        List<Review> query = queryFactory.selectFrom(review)
//                .where(review.pIdx.pIdx.eq(pIdx)).fetch();

        JPQLQuery<Review> query = queryFactory.selectFrom(review)
                .where(review.pIdx.pIdx.eq(pIdx))
                .orderBy(review.rDate.desc());

        List<Review> reviews = this.getQuerydsl().applyPagination(pageable, query).fetch();
//        Long total = queryFactory
//                .select(review.count())
//                .from(review)
//                .where(review.pIdx.pIdx.eq(pIdx))
//                .fetchOne();

        return new PageImpl<>(reviews, pageable, query.fetchCount());

    }






}
