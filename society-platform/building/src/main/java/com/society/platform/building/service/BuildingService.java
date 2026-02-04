package com.society.platform.building.service;

import com.society.platform.building.entity.Building;

public class BuildingService {
  public Building create(String code) {
    return new Building(code);
  }
}
