package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Like;

import java.util.Optional;

public interface LikeRepositoryCustom {

    Optional<Like> findLikedUser(Long pIdx, Long uIdx);
}
