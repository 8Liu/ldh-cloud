package com.liudehuang.auth;

import com.liudehuang.common.annotation.EnableLdhLettuceRedis;
import com.liudehuang.common.annotation.LdhCloudApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@LdhCloudApplication
@MapperScan("com.liudehuang.auth.mapper")
@EnableLdhLettuceRedis
public class LdhAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(LdhAuthApplication.class, args);
    }
}
