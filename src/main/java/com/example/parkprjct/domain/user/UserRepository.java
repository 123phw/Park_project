package com.example.parkprjct.domain.user;

import java.util.Optional;
import com.example.parkprjct.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findBygId(String gId);
}