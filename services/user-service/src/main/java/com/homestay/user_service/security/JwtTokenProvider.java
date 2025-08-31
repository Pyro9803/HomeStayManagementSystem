package com.homestay.user_service.security;

import com.homestay.user_service.config.JwtConfigurationProperties;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
  private final JwtConfigurationProperties jwtProperties;

  private Key getSigningKey() {
    byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getSecret());
    return Keys.hmacShaKeyFor(keyBytes);
  }

  private Claims parseToken(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(getSigningKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  public String generateToken(String email, String role) {
    Date now = new Date();
    Date expireDate = new Date(now.getTime() + jwtProperties.getJwtExpiration());

    return Jwts.builder()
        .setSubject(email)
        .claim("role", role)
        .claim("type", "ACCESS")
        .setIssuedAt(now)
        .setExpiration(expireDate)
        .signWith(getSigningKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  public String generateRefreshToken(String email, String role) {
    Date now = new Date();
    Date expireDate = new Date(now.getTime() + jwtProperties.getRefreshTokenExpiration());

    return Jwts.builder()
        .setSubject(email)
        .claim("role", role)
        .claim("type", "REFRESH")
        .setIssuedAt(now)
        .setExpiration(expireDate)
        .signWith(getSigningKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  public String getEmailFromToken(String token) {
    Claims claims = parseToken(token);

    return claims.getSubject();
  }

	public String getRoleFromToken(String token) {
    Claims claims = parseToken(token);

		return claims.get("role", String.class);
	}

  public boolean validateToken(String token) {
    try {
      parseToken(token);

      return true;
    } catch (JwtException | IllegalArgumentException e) {
      log.error("Invalid JWT Token: {}", e.getMessage());
      return false;
    }
  }

  public boolean isTokenExpired(String token) {
    Claims claims = parseToken(token);

    return claims.getExpiration().before(new Date());
  }
}
