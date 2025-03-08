package com.green_alert.green_alert_backend.auth.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// Va a ser el mapeo de la respuesta
public class AuthResponse {
    String token;
}
