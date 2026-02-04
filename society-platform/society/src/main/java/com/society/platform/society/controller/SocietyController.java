package com.society.platform.society.controller;

import com.society.platform.common.response.ApiResponse;

public class SocietyController {
  public ApiResponse status() {
    return new ApiResponse("society-service-ready");
  }
}
