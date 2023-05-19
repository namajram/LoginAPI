package com.api.sevice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.entity.Login;
import com.api.exception.ApiExceptionHandle;
import com.api.exception.InvalidCredentialsException;
import com.api.repository.LoginRepository;
import com.api.service.LoginService;
import com.api.util.JwtUtil;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private JwtUtil jwtUtil;

	
	@Override
	public ResponseEntity registerUser(Login login) {
try {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		if (login.getUsername() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username cannot be null");
        }
		Login user = new Login();
		
		if (loginRepository.findByUsername(login.getUsername()) != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username is already exist");
		}
        user.setUsername(login.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(login.getPassword()));
        loginRepository.save(user);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("User registered successfully");
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
	}

	@Override
	public ResponseEntity loginUser(Login login) {
		try{BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		Login username = loginRepository.findByUsername(login.getUsername());
		
		if (username == null || !bCryptPasswordEncoder.matches(login.getPassword(), username.getPassword())) {
            throw new InvalidCredentialsException ("Invalid username or password");
        }


		String token = jwtUtil.generateToken(username);
		
		return ResponseEntity.ok(token);}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	
}
