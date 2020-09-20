package com.liudehuang.auth;

import com.liudehuang.common.annotation.EnableLdhAuthExceptionHandler;
import com.liudehuang.common.annotation.EnableLdhServerProtect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableLdhAuthExceptionHandler
@EnableLdhServerProtect
public class LdhAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(LdhAuthApplication.class, args);
    }
}
