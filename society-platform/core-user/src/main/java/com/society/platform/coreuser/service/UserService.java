package com.society.platform.coreuser.service;

import com.society.platform.coreuser.entity.User;

public class UserService {
  public User buildUser(Long id, String name) {
    return new User(id, name);
  }
}
