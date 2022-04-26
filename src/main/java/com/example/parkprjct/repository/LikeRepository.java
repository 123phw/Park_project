package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Like;
import com.example.parkprjct.entity.Park;
import com.example.parkprjct.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface LikeRepository extends JpaRepository<Like, Long> {

    Page<Park> findByuIdx(Users user);

}
