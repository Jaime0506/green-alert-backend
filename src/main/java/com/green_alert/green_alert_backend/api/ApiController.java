package com.green_alert.green_alert_backend.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @GetMapping
    public String get() {
        return "Emote";
    }
}
