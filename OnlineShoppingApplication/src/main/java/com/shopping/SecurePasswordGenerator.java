package com.shopping;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurePasswordGenerator {
	public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "ruchi123";
        String encodedPassword = encoder.encode(rawPassword);
         
        System.out.println(encodedPassword);
    }
}
