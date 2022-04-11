package com.project.parkproject.security;

import com.project.parkproject.domain.user.UserService;
import com.project.parkproject.security.filter.TestTokenFilter;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import lombok.extern.slf4j.Slf4j;

@Profile("local")
@Configuration
@EnableWebSecurity
@Slf4j
public class TestSecurityConfig extends SecurityConfigBase {
    public TestSecurityConfig(UserService userService) {
        super(new TestTokenFilter(userService));
    }
}