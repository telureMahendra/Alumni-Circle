package com.society.platform.coreuser.controller;

import com.society.platform.common.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
  @GetMapping("/health")
  public ApiResponse health() {
    return new ApiResponse("user-service-ok");
  }
}
