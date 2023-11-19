package com.winz_fast.payload.response;

import lombok.Data;

@Data
public class UserRegisterResponse {

    private Long id;
    private String username;
    private String password;
    private String email;
   //

}
