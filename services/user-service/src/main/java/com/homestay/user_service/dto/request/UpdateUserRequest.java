package com.homestay.user_service.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {

  @Email(message = "Email should be valid")
  @Size(max = 100, message = "Email must not exceed 100 characters")
  private String email;

  @Size(max = 50, message = "First name must not exceed 50 characters")
  @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "First name should only contain letters and spaces")
  private String firstName;

  @Size(max = 50, message = "Last name must not exceed 50 characters")
  @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Last name should only contain letters and spaces")
  private String lastName;

  @Pattern(regexp = "^(\\+?[1-9]\\d{1,14})?$", message = "Phone number should be valid")
  private String phone;

  @Size(max = 200, message = "Address must not exceed 200 characters")
  private String address;
}
