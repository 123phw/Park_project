package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long>{
}
