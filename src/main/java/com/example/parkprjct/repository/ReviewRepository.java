package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Review;
import com.example.parkprjct.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
    List<Review> findByuIdx(Users user);
}
