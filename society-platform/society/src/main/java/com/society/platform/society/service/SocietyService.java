package com.society.platform.society.service;

import com.society.platform.society.entity.Society;

public class SocietyService {
  public Society register(String name) {
    return new Society(name);
  }
}
