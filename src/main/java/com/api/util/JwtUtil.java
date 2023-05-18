package com.api.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.api.beans.Login;

import io.jsonwebtoken.Jwts;



@Component
public class JwtUtil {

	public String generateToken(Login user) {
		Map<String, Object> claims = new HashMap<>();
	    claims.put("userId", user.getId());
	    claims.put("username", user.getUsername());
	    
	    Date issuedAt = new Date();
	    
		
	    return Jwts.builder()
	            .setClaims(claims)
	            .setIssuedAt(issuedAt).compact();
	}


}
