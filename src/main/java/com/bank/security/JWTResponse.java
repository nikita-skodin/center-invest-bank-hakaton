package com.bank.security;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class JWTResponse {
    private Long id;
    private String username;
    private String accessToken;
    private String refreshToken;
}
