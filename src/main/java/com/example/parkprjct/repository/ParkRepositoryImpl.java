package com.example.parkprjct.repository;

import com.example.parkprjct.dto.ParkDto;
import com.example.parkprjct.entity.*;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public class ParkRepositoryImpl extends QuerydslRepositorySupport implements ParkReposiitoryCustom {

    @Autowired
    private JPAQueryFactory queryFactory;
    private ParkRepository parkRepository;

    public ParkRepositoryImpl(){
        super(Park.class);
    }

    @Override
    public Page<Park> park(Pageable pageable){
        JPQLQuery<Park> sortquery = queryFactory.selectFrom(QPark.park);

        List<Park> parks = this.getQuerydsl().applyPagination(pageable, sortquery).fetch();
        return new PageImpl<Park>(parks, pageable, sortquery.fetchCount());
    }

    //공원목록(내림차순, 거리순 필터)
    @Override
    public Page<ParkDto> parkList(Pageable pageable){

        JPQLQuery<ParkDto> sortquery = queryFactory.select(Projections.fields(ParkDto.class,
                QPark.park.pIdx,
                QPark.park.pName,
                QPark.park.pImg,
                QPark.park.pArea,
                QPark.park.pAvgRate,
                QPark.park.pX,
                QPark.park.pY)).from(QPark.park);

        List<ParkDto> parks = this.getQuerydsl().applyPagination(pageable, sortquery).fetch();
        return new PageImpl<ParkDto>(parks, pageable, sortquery.fetchCount());
    }

    //공원명 검색 쿼리
    @Override
    public Page<ParkDto> findByName(Pageable pageable, String pName){
        JPQLQuery<ParkDto> pNameQuery = queryFactory.select(Projections.fields(ParkDto.class,
                QPark.park.pIdx,
                QPark.park.pName,
                QPark.park.pImg,
                QPark.park.pArea,
                QPark.park.pAvgRate,
                QPark.park.pX,
                QPark.park.pY)).from(QPark.park).where(containName(pName));
        //공원이름을 통해 park db를 불러오는 쿼리문

        List<ParkDto> parks = this.getQuerydsl().applyPagination(pageable, pNameQuery).fetch();
        return new PageImpl<ParkDto>(parks, pageable, pNameQuery.fetchCount());
        //Page처리 구현체.
    }

    //공원 지역구 검색 쿼리//질문
    @Override
    public Page<ParkDto> findByArea(Pageable pageable, String pArea){
        JPQLQuery<ParkDto> pAreaQuery = queryFactory.select(Projections.fields(ParkDto.class,
                        QPark.park.pIdx,
                        QPark.park.pName,
                        QPark.park.pImg,
                        QPark.park.pArea,
                        QPark.park.pAvgRate,
                        QPark.park.pX,
                        QPark.park.pY))
                .from(QPark.park)
                .where(eqArea(pArea));

        List<ParkDto> parks = this.getQuerydsl().applyPagination(pageable, pAreaQuery).fetch();
        return new PageImpl<ParkDto>(parks, pageable, pAreaQuery.fetchCount());
    }

    //공원명 + 지역구 검색 쿼리
    @Override
    public Page<ParkDto> findByAllOptions(Pageable pageable, String pName, String pArea){
        JPQLQuery<ParkDto> query =  queryFactory.select(Projections.fields(ParkDto.class,
                        QPark.park.pIdx,
                        QPark.park.pName,
                        QPark.park.pImg,
                        QPark.park.pArea,
                        QPark.park.pAvgRate,
                        QPark.park.pX,
                        QPark.park.pY))
                .from(QPark.park)
                .where(containName(pName), eqArea(pArea));

        List<ParkDto> parks = this.getQuerydsl().applyPagination(pageable, query).fetch();
        return new PageImpl<ParkDto>(parks, pageable, query.fetchCount());
    }


    private BooleanExpression eqArea(String pArea){
        if(pArea == null || pArea.isEmpty()){
            return null;
        }
        return QPark.park.pArea.eq(pArea);
    }


    private BooleanExpression containName(String pName){
        if(pName == null || pName.isEmpty()){
            return null;
        }
        return QPark.park.pName.containsIgnoreCase(pName);
        //문자열중 (pName)이 포함되어있는 pName을 리턴
    }

}
