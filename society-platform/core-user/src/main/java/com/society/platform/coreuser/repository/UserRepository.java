package com.society.platform.coreuser.repository;

import com.society.platform.coreuser.entity.User;

public interface UserRepository {
  User findById(Long id);
}
