package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Good;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Optional;

import static com.example.parkprjct.entity.QGood.good;

public class GoodRepositoryImpl extends QuerydslRepositorySupport implements GoodRepositoryCustom {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    public GoodRepositoryImpl() { super(Good.class); }

    @Override
    public Optional<Good> findGoodUser(Long rIdx, Long uIdx){
        Good query = jpaQueryFactory
                .selectFrom(good)
                .where(good.uIdx.uIdx.eq(uIdx), good.rIdx.rIdx.eq(rIdx))
                .fetchOne();

        return Optional.ofNullable(query);
        //값이 null이면 비어있는 optional객체를 반환
    }

}
