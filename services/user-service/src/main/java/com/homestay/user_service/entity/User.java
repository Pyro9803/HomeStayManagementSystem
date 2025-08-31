package com.homestay.user_service.entity;

import com.homestay.user_service.enums.AccountStatus;
import com.homestay.user_service.enums.StaffRole;
import com.homestay.user_service.enums.UserRole;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(
    name = "users",
    indexes = {
      @Index(name = "idx_email", columnList = "email"),
      @Index(name = "idx_role", columnList = "role"),
      @Index(name = "idx_status", columnList = "accountStatus")
    })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false, length = 100)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false, length = 50)
  private String firstName;

  @Column(nullable = false, length = 50)
  private String lastName;

  @Column(length = 20)
  private String phone;

  @Column(length = 200)
  private String address;

  @Enumerated(EnumType.STRING)
  private UserRole role = UserRole.GUEST;

  @Enumerated(EnumType.STRING)
  private StaffRole staffRole;

  @Enumerated(EnumType.STRING)
  private AccountStatus accountStatus = AccountStatus.INACTIVE;

  private boolean emailVerified = false;

  // Security fields
  private String activationToken;
  private LocalDateTime activationTokenExpiry;
  private String passwordResetToken;
  private LocalDateTime passwordResetTokenExpiry;
  private int loginAttempts = 0;
  private LocalDateTime lastLoginAt;
  private LocalDateTime lastFailedLoginAt;
  private LocalDateTime passwordChangedAt;
  private LocalDateTime activatedAt;
  private LocalDateTime promotedAt;

  @CreationTimestamp private LocalDateTime createdAt;

  @UpdateTimestamp private LocalDateTime updatedAt;
}
