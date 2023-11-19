package com.winz_fast.service;

import com.winz_fast.model.User;

import java.util.Optional;

public interface UserService {
    Iterable<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    void remove(Long id);

    User findByUsername(String username);
}
