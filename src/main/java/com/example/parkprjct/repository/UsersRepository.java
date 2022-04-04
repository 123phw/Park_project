package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users, Long>, UsersRepositoryCustom {
}
