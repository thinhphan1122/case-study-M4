package com.winz_fast.service.impl;

import com.winz_fast.model.User;
import com.winz_fast.payload.request.UserRegisterRequest;
import com.winz_fast.payload.response.UserRegisterResponse;
import com.winz_fast.repository.UserRepository;
import com.winz_fast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserRegisterResponse register(UserRegisterRequest userRegisterRequest) {
        String password = userRegisterRequest.getPassword();

        if(password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be blank!");
        }

        User user = User.builder()
                .username(userRegisterRequest.getUsername())
                .password(userRegisterRequest.getPassword())
                .build();

        userRepository.save(user);
        return null;
    }
}
