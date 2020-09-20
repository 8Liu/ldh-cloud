package com.liudehuang.test;

import com.liudehuang.common.annotation.LdhCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableFeignClients
@LdhCloudApplication
public class LdhServerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LdhServerTestApplication.class, args);
    }
}
