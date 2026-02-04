package com.society.platform.flat.service;

import com.society.platform.flat.entity.Flat;

public class FlatService {
  public Flat register(String number) {
    return new Flat(number);
  }
}
