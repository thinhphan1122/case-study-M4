package com.winz_fast.controller;

import com.winz_fast.dto.request.UserLoginRequestDto;
import com.winz_fast.dto.response.UserLoginResponseDto;
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

//    @GetMapping("/login")
//    public ModelAndView login() {
//        return new ModelAndView("/login");
//    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto request) {

        User user = userService.findByUsername(request.getUsername());

        if (user == null || !(request.getPassword().equals(user.getPassword()))) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        UserLoginResponseDto response = new UserLoginResponseDto();
        response.setUsername(user.getUsername());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setEmail(user.getEmail());
        return ResponseEntity.ok(response);
    }
}
