package com.example.parkprjct.repository;

import com.example.parkprjct.entity.Users;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class UsersRepositoryImpl extends QuerydslRepositorySupport implements UsersRepositoryCustom {

    @Autowired
    private JPAQueryFactory queryFactory;
    private UsersRepository usersRepository;

    public UsersRepositoryImpl(){
        super(Users.class);
    }




}
