package com.homestay.user_service.dto.request;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequest {

  @NotBlank(message = "Current password is required")
  private String currentPassword;

  @NotBlank(message = "New password is required")
  @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
  private String newPassword;

  @NotBlank(message = "Confirm password is required")
  private String confirmPassword;

  @AssertTrue(message = "New password and confirm password must match")
  public boolean isPasswordMatching() {
    return newPassword != null && newPassword.equals(confirmPassword);
  }
}
