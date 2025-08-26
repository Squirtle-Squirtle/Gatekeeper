package com.gatekeeper.authenticatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.gatekeeper.models")
public class AuthenticatorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticatorServiceApplication.class, args);
    }

}
