package com.green_alert.green_alert_backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:jwt.application.properties")
public class JwtPropertiesConfig {

}
