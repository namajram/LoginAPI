package com.api.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class Securityconfig  {
@Bean
public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
	http.authorizeHttpRequests().requestMatchers("/register","/signin","/h2-console/**","/console/**").permitAll();
	http.authorizeHttpRequests().anyRequest().authenticated();
	http.formLogin();
	http.httpBasic();
	
	http.csrf().disable();
    http.headers().frameOptions().disable();
	return http.build();

}
}

