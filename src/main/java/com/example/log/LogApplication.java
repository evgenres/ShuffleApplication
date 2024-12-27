package com.example.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogApplication {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application-log");
        SpringApplication.run(LogApplication.class, args);
    }
}
