package com.gatekeeper.authenticatorservice;

import com.gatekeeper.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody Map<String, String> req) {
        String username = req.get("username");
        String password = req.get("password");
        return ResponseEntity.ok(authService.register(username, password));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> req) {
        String username = req.get("username");
        String password = req.get("password");
        return ResponseEntity.ok(authService.login(username, password));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody Map<String, String> req) {
        return ResponseEntity.ok(
                Map.of("token", authService.refreshToken(req.get("token")))
        );
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        // In JWT, logout is usually handled client-side by deleting token
        return ResponseEntity.ok(Map.of("message", "Logged out"));
    }
}