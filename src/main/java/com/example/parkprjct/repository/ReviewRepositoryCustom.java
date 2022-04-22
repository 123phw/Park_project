package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewRepositoryCustom {

    Page<Review> reviewList(Long pIdx, Pageable pageable);
}
