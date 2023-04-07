package com.api.backend.controller;

import com.api.backend.config.JpaUserDetailsService;
import com.api.backend.config.JwtUtils;
import com.api.backend.config.UserSecurity;
import com.api.backend.dto.AuthenticationRequest;
import com.api.backend.dto.LoginResponseDto;
import com.api.backend.dto.UsersRequest;
import com.api.backend.entity.Users;
import com.api.backend.repository.UsersRepository;
import com.api.backend.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JpaUserDetailsService jpaUserDetailsService;
    private final AuthService authService;
    private final JwtUtils jwtUtils;
    private final UsersRepository usersRepository;

    @PostMapping("/authenticate")
    public ResponseEntity<LoginResponseDto> authenticate(@RequestBody AuthenticationRequest request, HttpServletResponse response) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword(),
                            new ArrayList<>()));
            final UserDetails user = jpaUserDetailsService.loadUserByUsername(request.getEmail());
            if (user != null) {
                String jwt = jwtUtils.generateToken(user);

                Users userEntity = usersRepository.findByEmail(request.getEmail()).get();
                return ResponseEntity.ok(LoginResponseDto
                        .builder()
                                .status(true)
                                .token(jwt)
                                .users(userEntity)
                        .build());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    LoginResponseDto
                            .builder()
                            .status(false)
                            .message("Information incorrect")
                            .build()
            );
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(400).body(LoginResponseDto
                    .builder()
                            .status(false)
                            .message(e.getMessage())
                    .build());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserSecurity> register(@RequestBody UsersRequest user) throws Exception {
        return ResponseEntity.ok(authService.AddUser(user).map(UserSecurity::new).orElseThrow(() -> new Exception("Unknown")));
    }

}