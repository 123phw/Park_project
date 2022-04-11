package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Park;
import com.example.parkprjct.entity.QLike;
import com.example.parkprjct.entity.QPark;
import com.example.parkprjct.entity.QUsers;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
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

    //
    @Override
    public Page<Park> findBySearchOption(Pageable pageable, String pName){
        JPQLQuery<Park> pNameQuery = queryFactory.selectFrom(QPark.park).where(containName(pName));
        //공원이름을 통해 park db를 불러오는 쿼리문

        List<Park> parks = this.getQuerydsl().applyPagination(pageable, pNameQuery).fetch();
        return new PageImpl<Park>(parks, pageable, pNameQuery.fetchCount());
        //Page처리 구현체.
    }

//    @Override
//    public Park readMorePark(Long pIdx) throws UsernameNotFoundException {
//        return parkRepository.findById(pIdx)
//                .orElse(() -> {
//                    throw new UsernameNotFoundException("해당하는 공원이 없습니다.");
//                });
//    }

    //지역구는 태그누르고 공원이름으로만 검색함
//    private BooleanExpression eqArea(String pArea){
//        if(pArea == null || pArea.isEmpty()){
//            return null;
//        }
//        return QPark.park.pArea.eq(pArea);
//    }


    private BooleanExpression containName(String pName){
        if(pName == null || pName.isEmpty()){
            return null;
        }
        return QPark.park.pName.containsIgnoreCase(pName);
        //문자열중 (pName)이 포함되어있는 pName을 리턴
    }




}
