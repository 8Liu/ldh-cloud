package com.liudehuang.test;

import com.liudehuang.common.annotation.EnableLdhAuthExceptionHandler;
import com.liudehuang.common.annotation.EnableLdhOauth2FeignClient;
import com.liudehuang.common.annotation.EnableLdhServerProtect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableLdhAuthExceptionHandler
@EnableFeignClients
@EnableLdhOauth2FeignClient
@EnableLdhServerProtect
public class LdhServerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LdhServerTestApplication.class, args);
    }
}
