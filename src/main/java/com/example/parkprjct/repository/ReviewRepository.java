package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Review;
import com.example.parkprjct.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
     Page<Review> findByuIdx(Users user, Pageable pageable);
}
