package com.example.parkprjct.repository;

import com.example.parkprjct.dto.ParkDto;
import com.example.parkprjct.entity.Park;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//queryDSL구현 기능
public interface ParkReposiitoryCustom {

    Page<Park> park(Pageable pageable);
    //공원db

    Page<ParkDto> parkList(Pageable pageable);
    //공원목록(별점순, 거리순 정렬)

    Page<ParkDto> findByName(Pageable pageable, String pName);
    //공원명 검색

    Page<ParkDto> findByArea(Pageable pageable, String pArea);
    //공원 지역구 검색

    Page<ParkDto> findByAllOptions(Pageable pageable, String pName, String pArea);
    //공원명 + 지역구 검색

    Double updateAvgRate(Long pIdx);
}
