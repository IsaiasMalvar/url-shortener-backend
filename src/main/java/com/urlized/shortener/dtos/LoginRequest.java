package com.urlized.shortener.dtos;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;
}
