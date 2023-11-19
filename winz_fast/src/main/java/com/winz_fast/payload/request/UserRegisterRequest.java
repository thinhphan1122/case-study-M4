package com.winz_fast.payload.request;

import lombok.Data;

/**
 * @author ADMIN
 */
@Data
public class UserRegisterRequest {

    private String username;
    private String password;
    private String email;
    //
}
