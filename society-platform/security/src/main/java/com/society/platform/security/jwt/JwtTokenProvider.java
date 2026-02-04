package com.society.platform.security.jwt;

public class JwtTokenProvider {
  public String createToken(String subject) {
    return "token-for-" + subject;
  }
}
