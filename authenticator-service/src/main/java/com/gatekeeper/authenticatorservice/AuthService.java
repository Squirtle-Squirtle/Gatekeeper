package com.gatekeeper.authenticatorservice;

import com.gatekeeper.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepo authRepo;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtils jwtUtils;

    public User register(String username, String password) {
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .role("ROLE_USER")
                .build();
        return authRepo.save(user);
    }

    public String login(String username, String password) {
        Optional<User> user = authRepo.findByUsername(username);
        if(user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return jwtUtils.generateToken(user.get().getUsername());
        }
        else
        {
            throw new UsernameNotFoundException("Username or password incorrect");
        }

    }

    public String refreshToken(String oldToken) {
        if(jwtUtils.validateToken(oldToken)) {
            return jwtUtils.generateToken(jwtUtils.extractUsername(oldToken));
        }
        throw new RuntimeException("Invalid token");
    }
}
