package com.api.service;

import org.springframework.http.ResponseEntity;

import com.api.entity.Login;

public interface LoginService {
	ResponseEntity registerUser(Login login);
    ResponseEntity loginUser(Login login);
}
