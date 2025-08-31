package com.homestay.user_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	private String code;
	private String message;
	private List<String> details;
	private LocalDateTime timestamp =  LocalDateTime.now();

	public ErrorResponse(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
