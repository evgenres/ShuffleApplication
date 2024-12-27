package com.example.shuffle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
    public class ShuffleApplication {
        public static void main(String[] args) {
            System.setProperty("spring.config.name", "application");
            SpringApplication.run(ShuffleApplication.class, args);
        }

        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }

