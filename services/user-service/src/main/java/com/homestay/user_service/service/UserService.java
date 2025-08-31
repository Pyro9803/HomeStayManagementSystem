package com.homestay.user_service.service;

import com.homestay.user_service.dto.UserDTO;
import com.homestay.user_service.dto.request.ChangePasswordRequest;
import com.homestay.user_service.dto.request.CreateUserRequest;
import com.homestay.user_service.dto.request.LoginRequest;
import com.homestay.user_service.dto.request.UpdateUserRequest;
import com.homestay.user_service.dto.response.LoginResponse;
import com.homestay.user_service.enums.StaffRole;
import com.homestay.user_service.enums.UserRole;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface UserService {
  UserDTO createUser(CreateUserRequest request);

  LoginResponse authenticate(LoginRequest request);

  UserDTO getUserByEmail(String email);

  UserDTO getUserById(Long id);

  UserDTO updateUser(String email, UpdateUserRequest request);

  void deleteUser(String email);

  void changePassword(String email, ChangePasswordRequest request);

  void resetPassword(String email);

  void confirmPasswordReset(String token, String newPassword);

  void activateUser(String activationToken);

  void deactivateUser(String email);

  List<UserDTO> getAllUsers(Pageable pageable);

  List<UserDTO> getUsersByRole(UserRole role, Pageable pageable);

  boolean existsByEmail(String email);

  UserDTO promoteUserToStaff(Long userId, StaffRole staffRole);
}
