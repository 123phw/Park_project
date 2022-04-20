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

  //  public Page<ReviewDto> reviewList(Long pIdx,Pageable pageable){


//        JPQLQuery<ReviewDto> query = queryFactory.selectFrom(ReviewDto)
//                .where(pIdx.castToNum(Long.class));
//    }
//
//    private BooleanExpression eqPIdx(Long pIdx){
//        if(pIdx == null){
//            return null;
//        }
//        return QReview.review.pIdx.eq(pIdx);
//    }





}
