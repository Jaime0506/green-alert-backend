package com.green_alert.green_alert_backend.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green_alert.green_alert_backend.auth.models.User;

public interface UserRepository extends JpaRepository<User, UUID>{
    Optional<User> findByUsername(String username);
}
