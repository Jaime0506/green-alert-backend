package com.green_alert.green_alert_backend.auth.services;

import org.springframework.stereotype.Service;

import com.green_alert.green_alert_backend.Jwt.JwtService;
import com.green_alert.green_alert_backend.auth.models.AuthResponse;
import com.green_alert.green_alert_backend.auth.models.LoginRequest;
import com.green_alert.green_alert_backend.auth.models.RegisterRequest;
import com.green_alert.green_alert_backend.auth.models.Role;
import com.green_alert.green_alert_backend.auth.models.User;
import com.green_alert.green_alert_backend.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
            .username(request.getUsername())
            .password(request.getPassword())
            .firstname(request.getFirstname())
            .lastname(request.getLastname())
            .country(request.getCountry())
            .role(Role.USER)
            .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
    }
}
