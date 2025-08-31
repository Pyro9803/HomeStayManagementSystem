package com.homestay.user_service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.jwt")
@Data
public class JwtConfigurationProperties {
  private String secret;
  private Long jwtExpiration;
  private Long refreshTokenExpiration;
}
