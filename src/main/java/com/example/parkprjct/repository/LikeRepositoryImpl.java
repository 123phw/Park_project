package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Like;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Optional;

import static com.example.parkprjct.entity.QLike.like;

public class LikeRepositoryImpl extends QuerydslRepositorySupport implements LikeRepositoryCustom {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    public LikeRepositoryImpl() { super(Like.class); }

    @Override
    public Optional<Like> findLikedUser(Long pIdx, Long uIdx){
        Like query = jpaQueryFactory
                .selectFrom(like)
                .where(like.uIdx.uIdx.eq(uIdx), like.pIdx.pIdx.eq(pIdx))
                .fetchOne();

        return Optional.ofNullable(query);
        //값이 null이면 비어있는 optional객체를 반환
    }


}
