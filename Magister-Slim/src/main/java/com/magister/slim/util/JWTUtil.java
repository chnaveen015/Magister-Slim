package com.magister.slim.util;

import java.sql.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier.BaseVerification;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Clock;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.magister.slim.entity.User;

public class JWTUtil {

	private static final String JWT_SECRET = "My Secret";
	
	private static final String ISSUER = "Magister.slim";

	private static final Algorithm JWT_ALGORITHM = Algorithm.HMAC256(JWT_SECRET);

//	public static String generateToken(User payload) {
//		String token = null;
//		try {
//			token = JWT.create().withIssuer(ISSUER).sign(JWT_ALGORITHM);
//		} catch (JWTCreationException exception) {
//		}
//		return token;
//	}

	public static String generateToken(String payload) {
		
		String token = null;
		try {
			token = JWT.create().withIssuer(ISSUER).withClaim("payload", payload).sign(JWT_ALGORITHM);
		} catch (JWTCreationException exception) {
		}
		return token;
	}

	public static boolean verifyToken(String token) {
		try {
			JWTVerifier verifier = JWT.require(JWT_ALGORITHM).withIssuer(ISSUER).acceptLeeway(1).acceptExpiresAt(5).build(); // Reusable verifier instance
		} catch (JWTVerificationException exception) {
			exception.printStackTrace();
			System.out.println("Hii");
			return false;
		}
		
		return true;
		
	}

	public static String getPayload(String token) {
		DecodedJWT jwt = null;
		String ss=null;
		try {
		    jwt = JWT.decode(token);
		    Date expiresAt = (Date) jwt.getExpiresAt();
		    System.out.println(expiresAt);
		    ss=jwt.getPayload();
		} catch (JWTDecodeException exception){
		}
		return ss;
	}
	
}