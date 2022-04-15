package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Park;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkRepository extends JpaRepository<Park, Long> {
}
