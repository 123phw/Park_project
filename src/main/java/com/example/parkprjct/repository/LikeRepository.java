package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LikeRepository extends JpaRepository<Like, Long> {
}
