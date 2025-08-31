package com.homestay.user_service.service.impl;

import com.homestay.user_service.dto.UserDTO;
import com.homestay.user_service.dto.request.ChangePasswordRequest;
import com.homestay.user_service.dto.request.CreateUserRequest;
import com.homestay.user_service.dto.request.LoginRequest;
import com.homestay.user_service.dto.request.UpdateUserRequest;
import com.homestay.user_service.dto.response.LoginResponse;
import com.homestay.user_service.enums.StaffRole;
import com.homestay.user_service.enums.UserRole;
import com.homestay.user_service.service.UserService;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Override
  public UserDTO createUser(CreateUserRequest request) {
    return null;
  }

  @Override
  public LoginResponse authenticate(LoginRequest request) {
    return null;
  }

  @Override
  public UserDTO getUserByEmail(String email) {
    return null;
  }

  @Override
  public UserDTO getUserById(Long id) {
    return null;
  }

  @Override
  public UserDTO updateUser(String email, UpdateUserRequest request) {
    return null;
  }

  @Override
  public void deleteUser(String email) {}

  @Override
  public void changePassword(String email, ChangePasswordRequest request) {}

  @Override
  public void resetPassword(String email) {}

  @Override
  public void confirmPasswordReset(String token, String newPassword) {}

  @Override
  public void activateUser(String activationToken) {}

  @Override
  public void deactivateUser(String email) {}

  @Override
  public List<UserDTO> getAllUsers(Pageable pageable) {
    return List.of();
  }

  @Override
  public List<UserDTO> getUsersByRole(UserRole role, Pageable pageable) {
    return List.of();
  }

  @Override
  public boolean existsByEmail(String email) {
    return false;
  }

  @Override
  public UserDTO promoteUserToStaff(Long userId, StaffRole staffRole) {
    return null;
  }
}
