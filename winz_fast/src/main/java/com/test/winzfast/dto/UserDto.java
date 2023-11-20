package com.test.winzfast.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String avatar;
}
