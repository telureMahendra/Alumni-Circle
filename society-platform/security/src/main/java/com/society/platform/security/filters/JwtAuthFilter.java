package com.society.platform.security.filters;

public class JwtAuthFilter {
  public boolean isTokenValid(String token) {
    return token != null && !token.isBlank();
  }
}
