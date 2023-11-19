package com.winz_fast.dto.response;

import lombok.Data;

@Data
public class UserLoginResponseDto {
    private String username;
    private String email;
    private String phoneNumber;
}
