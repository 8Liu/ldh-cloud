package com.liudehuang.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LdhAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(LdhAuthApplication.class, args);
    }
}
