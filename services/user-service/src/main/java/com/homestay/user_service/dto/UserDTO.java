package com.homestay.user_service.dto;

import com.homestay.user_service.enums.AccountStatus;
import com.homestay.user_service.enums.StaffRole;
import com.homestay.user_service.enums.UserRole;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
  private Long id;
  private String email;
  private String firstName;
  private String lastName;
  private String phone;
  private String address;
  private UserRole role;
  private StaffRole staffRole;
  private AccountStatus accountStatus;
  private boolean emailVerified;
  private LocalDateTime lastLoginAt;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
