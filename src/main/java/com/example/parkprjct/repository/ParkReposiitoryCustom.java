package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Park;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
//queryDSL구현 기능
public interface ParkReposiitoryCustom {

    Page<Park> findBySearchOption(Pageable pageable, String pName);

    //Optional<Park> readMorePark(Long pIdx);
}
