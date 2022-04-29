package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodRepository extends JpaRepository<Good, Long>, GoodRepositoryCustom {
}
