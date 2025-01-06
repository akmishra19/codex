package com.example.codex.jwt;

import java.util.Date;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;

@Component
public class JwtUtil {
	
	private static final Logger logger= Logger.getLogger(JwtUtil.class.getName());

	private  String SECRET_KEY = "e3b0c44298fc1c1";

	public String generateToken(String userName) {
	String token =Jwts.builder().setSubject(userName).setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
			.signWith(SignatureAlgorithm.HS256,SECRET_KEY)
			.compact();
	
	
    logger.info("Generated Token: " + token); 
return token;
	}
	
	private Claims extractAllClaims(String token) {
		try {
			
		
		return Jwts.parser()
				.setSigningKey(SECRET_KEY)
				.parseClaimsJws(token)
				.getBody();
	}catch (JwtException e) {
        logger.severe("Token parsing failed: " + e.getMessage());
        throw new IllegalArgumentException("Invalid token", e); // Handle error gracefully
    }}
	
	public String extractUsername(String token) {
		String username= extractAllClaims(token).getSubject();
		return username;
	}
	
	public boolean isTokenExpired(String token) {
		boolean expired= extractAllClaims(token).getExpiration().before(new Date());
        logger.info("Token Expired: " + expired); // Log expiration status
		return expired;
	}

	public Boolean validateToken(String token,String userName) {
	boolean isValid=extractUsername(token).equals(userName) && !isTokenExpired(token);
    logger.info("Token Validation Result: gasn " + isValid); // Log validation result
	return isValid;
	}
	
	
	
//	public String extractUserName(String token) {
//		return extractAllClaims(token).getSubject();	
//	}
//	
//	  public Boolean isTokenExpired(String token) {
//	        return extractAllClaims(token).getExpiration().before(new Date());
//	    }
}
