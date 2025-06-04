package com.kadir.zeytuniPOS.dev;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
public class PasswordTestRunner {

    private final PasswordEncoder passwordEncoder;

    public PasswordTestRunner(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void run() {
        System.out.println("PasswordTestRunner aktif!");
        String raw = "123456";
        String hash = passwordEncoder.encode(raw);
        System.out.println("Yeni hash: " + hash);
    }
}
