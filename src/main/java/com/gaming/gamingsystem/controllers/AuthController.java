package com.gaming.gamingsystem.controllers;

import com.gaming.gamingsystem.services.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")   // 👈 optional prefix for clarity
public class AuthController {

    private final UsersService usersService;

    public AuthController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/auth")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        var opt = usersService.findByUsername(username);

        if (opt.isPresent() && opt.get().getPassword().equals(password)) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login successful ✅");
            response.put("token", "fake-jwt-token"); // replace later with real JWT
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(401)
                .body(Map.of("error", "Invalid credentials ❌"));
    }
}
