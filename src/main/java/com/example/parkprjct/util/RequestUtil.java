package com.project.parkproject.util;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    public static String getAuthorizationToken(String header) {
        if (header == null || !header.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid authorization header");
        }
        // Remove Bearer from string

        // parts[0] : bearer, parts[1] : token
        String[] parts = header.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid authorization header");
        }
        // Get token
        return parts[1];
    }

    public static String getAuthorizationToken(HttpServletRequest request) {
        return getAuthorizationToken(request.getHeader("Authorization"));
    }
}