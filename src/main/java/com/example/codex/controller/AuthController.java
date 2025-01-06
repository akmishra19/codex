package com.example.codex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.codex.jwt.JwtUtil;

import io.swagger.annotations.ApiOperation;

@RestController
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtil jwtUtil;

	@PostMapping("/authenticate")
	@ApiOperation(value="Get Employee By id")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
		
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
		
		System.out.println("In /authenticate api");
		return jwtUtil.generateToken(authRequest.getUsername());
	}

}
