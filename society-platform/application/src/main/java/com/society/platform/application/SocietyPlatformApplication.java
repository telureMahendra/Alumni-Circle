package com.society.platform.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.society.platform")
public class SocietyPlatformApplication {
  public static void main(String[] args) {
    SpringApplication.run(SocietyPlatformApplication.class, args);
  }
}
