package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Good;

import java.util.Optional;

public interface GoodRepositoryCustom {

    Optional<Good> findGoodUser(Long rIdx, Long uIdx);
}
