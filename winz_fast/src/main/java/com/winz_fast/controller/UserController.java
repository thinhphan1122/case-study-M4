package com.winz_fast.controller;

import com.winz_fast.payload.request.UserRegisterRequest;
import com.winz_fast.payload.request.UserLoginRequest;
import com.winz_fast.payload.response.UserRegisterResponse;
import com.winz_fast.payload.response.UserLoginResponse;
import com.winz_fast.model.User;
import com.winz_fast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Iterable<User>> listUser() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest request) {

        User user = userService.findByUsername(request.getUsername());

        if (user == null || !(request.getPassword().equals(user.getPassword()))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        UserLoginResponse response = new UserLoginResponse();
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(@RequestBody UserRegisterRequest request) {
        UserRegisterResponse response = new UserRegisterResponse();
        List<User> userList = (List<User>) userService.findAll();
        if (userList.stream().noneMatch(user -> user.getUsername().equals(request.getUsername()))) {
            User newUser = User.builder()
                    .username(request.getUsername())
                    .password(request.getPassword())
                    .email(request.getEmail())
                    .build();
            userService.save(newUser);
        } else return ResponseEntity.status(HttpStatus.CONFLICT).build();

        return ResponseEntity.ok(response);
    }
}
