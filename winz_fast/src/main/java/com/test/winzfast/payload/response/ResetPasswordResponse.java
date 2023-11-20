package com.test.winzfast.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ResetPasswordResponse {

    private String message;
    private String username;

    public ResetPasswordResponse(String s, HttpStatus httpStatus) {
    }
}
