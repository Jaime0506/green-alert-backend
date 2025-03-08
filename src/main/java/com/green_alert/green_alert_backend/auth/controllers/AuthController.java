package com.green_alert.green_alert_backend.auth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green_alert.green_alert_backend.auth.models.AuthResponse;
import com.green_alert.green_alert_backend.auth.models.LoginRequest;
import com.green_alert.green_alert_backend.auth.models.RegisterRequest;
import com.green_alert.green_alert_backend.auth.services.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/")
    public String get() {
        return "Emote";
    }
    
    @PostMapping("/login")
    // El response entity es la forma en que se va a resolver la peticion HTTP, es decir
    // que estructura va a tener la respuesta

    // Y en los parametros recuperamos el Body de neustra peticion, que deberia tener la estructura de LoginRequest
    // el resto de elementos que se manden en la peticion, los ignora
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registe(@RequestBody RegisterRequest request) {
        
        return ResponseEntity.ok(new AuthResponse());
    }
}
