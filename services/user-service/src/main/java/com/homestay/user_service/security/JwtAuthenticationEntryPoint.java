package com.homestay.user_service.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homestay.user_service.dto.response.ErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
		response.setContentType(MediaType.APPLICATION_JSON);
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		ErrorResponse errorResponse = new ErrorResponse("UNAUTHORIZED", "Full authentication is required to access this resource");
		ObjectMapper mapper = new ObjectMapper();

		response.getWriter().write(mapper.writeValueAsString(errorResponse));
	}
}
