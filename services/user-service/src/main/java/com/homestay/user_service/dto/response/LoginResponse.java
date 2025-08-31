package com.homestay.user_service.dto.response;

import com.homestay.user_service.dto.UserDTO;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse {
  private String token;
  private UserDTO user;
  private LocalDateTime expiresAt;
  private String tokenType = "Bearer";
}
