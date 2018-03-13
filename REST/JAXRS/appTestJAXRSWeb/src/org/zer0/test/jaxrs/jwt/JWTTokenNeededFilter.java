package org.zer0.test.jaxrs.jwt;

import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.core.HttpHeaders;

@Interceptor
@JWTTokenNeeded
public class JWTTokenNeededFilter {

	public void filter(InvocationContext requestContext) throws Exception {
		String a=HttpHeaders.AUTHORIZATION;
		// Get the HTTP Authorization header from the request
		
//		String authorizationHeader = requestContext.getContextData();
//
//		// Extract the token from the HTTP Authorization header
//		String token = authorizationHeader.substring("Bearer".length()).trim();
//
//		try {
//			// Validate the token
//			Key key = keyGenerator.generateKey();
//			Jwts.parser().setSigningKey(key).parseClaimsJws(token);
//			logger.info("#### valid token : " + token);
//
//		} catch (Exception e) {
//			logger.severe("#### invalid token : " + token);
//			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
//		}
	}
}
