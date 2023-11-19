package com.winz_fast.payload.request;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String username;
    private String password;
}
