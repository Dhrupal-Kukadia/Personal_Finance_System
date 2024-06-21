package org.finance.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PasswordService {
    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public boolean matchPassword(String password, String hashedPassword) {
        return bCryptPasswordEncoder.matches(password, hashedPassword);
    }
}
