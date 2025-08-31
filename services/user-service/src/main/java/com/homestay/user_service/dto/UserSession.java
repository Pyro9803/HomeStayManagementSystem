package com.homestay.user_service.dto;

import com.homestay.user_service.enums.UserRole;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSession {
  private Long userId;
  private String email;
  private UserRole role;
  private LocalDateTime loginTime;
}
