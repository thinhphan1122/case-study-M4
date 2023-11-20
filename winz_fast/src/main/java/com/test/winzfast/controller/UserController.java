package com.test.winzfast.controller;

import com.test.winzfast.exception.DuplicatedDataException;
import com.test.winzfast.exception.InvalidInputException;
import com.test.winzfast.payload.request.LoginRequest;
import com.test.winzfast.payload.request.RegisterRequest;
import com.test.winzfast.payload.response.LoginResponse;
import com.test.winzfast.payload.response.RegisterResponse;
import com.test.winzfast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) throws InvalidInputException {
        LoginResponse user = userService.login(loginRequest);
        if (user != null) {
            return new ResponseEntity<>("Login success!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Login failed! Invalid username or password.", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        try {
            RegisterResponse registerResponse = userService.register(registerRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(String.valueOf(registerResponse));
        } catch (DuplicatedDataException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User is already exist!");
        }
    }
}
