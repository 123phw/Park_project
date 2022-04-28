package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Like;
import com.example.parkprjct.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LikeRepository extends JpaRepository<Like, Long>, LikeRepositoryCustom {

    Page<Like> findByuIdx(Users user, Pageable pageable);

}
