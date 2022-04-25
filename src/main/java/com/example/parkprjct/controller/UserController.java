package com.example.parkprjct.controller;

import com.example.parkprjct.domain.user.UserService;
import com.example.parkprjct.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import com.example.parkprjct.entity.Users;

import org.springframework.security.core.Authentication;


@RequestMapping("/users")
@RestController
@Slf4j
public class UserController {
    private String activeProfile;
    private final UserService userService;

    @Autowired
    public UserController(UserService userService,
                          Environment environments) {
        this.userService = userService;
        this.activeProfile = environments.getActiveProfiles()[0];
        log.info("activeProfile: {}", activeProfile);
    }

    @GetMapping("/me")
    public Users login(Authentication authentication) {
        return (Users) authentication.getPrincipal();
    }


    @PostMapping("")
    public Users signup(@RequestBody SignupDTO signupDTO,
                       @RequestHeader("Authorization") String authorization) {
        String token = RequestUtil.getAuthorizationToken(authorization);
        if(activeProfile.equals("local")) {
            return userService.signupMock(signupDTO, token);
        } else {
            log.info("signDto :" + signupDTO);
            return userService.signup(signupDTO, token);
        }
    }


}