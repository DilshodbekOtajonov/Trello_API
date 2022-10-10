package com.example.trelloApi.dto.jwt;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 12:01 PM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */
public record JwtResponseDto(
        String accessToken,
        String refreshToken,
        String tokenType) {
}
