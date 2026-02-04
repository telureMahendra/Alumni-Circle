package com.society.platform.federation.controller;

import com.society.platform.common.response.ApiResponse;

public class FederationController {
  public ApiResponse status() {
    return new ApiResponse("federation-service-ready");
  }
}
