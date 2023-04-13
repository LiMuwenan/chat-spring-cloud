package com.ligen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConnectionApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConnectionApplication.class, args);
    }
}
