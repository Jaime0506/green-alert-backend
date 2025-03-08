package com.green_alert.green_alert_backend.auth.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Permite crear getter y setters de manera automatica
@Data
// Permite generar un constructor con los argumentos que deseemo
@Builder
// Todos los argumentos requeridos en el constructor
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    String username;
    String password;
}