package com.api.backend.dto;

import com.api.backend.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

@Builder
@AllArgsConstructor
@Data
public class LoginResponseDto {
    private boolean status;
    private String token;
    private String message;
    private Users users;
}
