package com.project.parkproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

import com.project.parkproject.entity.Users;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;


@RequestMapping("/users")
@RestController
@Slf4j
public class UserController {
    @GetMapping("/me")
    public Users login(Authentication authentication) {
        return (Users) authentication.getPrincipal();
    }

}