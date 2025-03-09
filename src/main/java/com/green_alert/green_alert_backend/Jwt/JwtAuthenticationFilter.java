package com.green_alert.green_alert_backend.Jwt;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

// Al extender de la clase Abbstracta OncePerRequestFilter, se asegura que el filtro se ejecute una vez por cada request
// y no una vez por cada petición de recurso, ademas de que nos permite crear nuestros propios filtros

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        // Cuando usamos autenticacion basada en token, deberia iniciar con la palabra Bearer
        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }

    @SuppressWarnings("null")
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String token = getTokenFromRequest(request);
        
        if (token == null) {
            // Si no hay token, se continua con la cadena de filtros
            filterChain.doFilter(request, response);
            return;

        }
        // Continua con la cadena de filtros
        filterChain.doFilter(request, response);
    }
}
