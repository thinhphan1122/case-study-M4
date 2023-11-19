package com.winz_fast.dto.request;

import lombok.Data;

@Data
public class UserLoginRequestDto {
    private String username;
    private String password;
}
