package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.Login;
import com.api.sevice.impl.LoginServiceImpl;

@RestController
public class LoginController {
	
	@Autowired
	private LoginServiceImpl loginServiceImpl;
	
	 @PostMapping("/register")
	    public ResponseEntity registerUser(@RequestBody Login login) {
	        return loginServiceImpl.registerUser(login);
	    }

	    @PostMapping("/signin")
	    public ResponseEntity loginUser(@RequestBody Login login) {
	        return loginServiceImpl.loginUser(login);
	    }

}
