package com.winz_fast.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String dateOfBirth;
    private String email;
    private String fullName;
    private String username;
    private String password;
    private String phoneNumber;
    private String avatar;
}
