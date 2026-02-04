package com.society.platform.federation.service;

import com.society.platform.federation.entity.Federation;

public class FederationService {
  public Federation create(String name) {
    return new Federation(name);
  }
}
