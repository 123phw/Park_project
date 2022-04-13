package com.project.parkproject.controller;

import com.project.parkproject.domain.user.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;


@RequestMapping("/users")
@RestController
@Slf4j
public class UserController {
    @GetMapping("/me")
    public User login(Authentication authentication) {
        return (User) authentication.getPrincipal();
    }

}