package org.example.heritagebackend.configure;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    public static BCryptPasswordEncoder getInstance() {
        return PASSWORD_ENCODER;
    }

}
