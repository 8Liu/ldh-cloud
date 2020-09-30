package com.liudehuang.system;

import com.liudehuang.common.annotation.EnableLdhAuthExceptionHandler;
import com.liudehuang.common.annotation.EnableLdhOauth2FeignClient;
import com.liudehuang.common.annotation.EnableLdhServerProtect;
import com.liudehuang.common.annotation.LdhCloudApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableLdhAuthExceptionHandler//认证类型异常翻译
//@EnableLdhServerProtect//开启微服务防护，避免客户端绕过网关直接请求微服务
//@EnableLdhOauth2FeignClient//开启带令牌的Feign请求，避免微服务内部调用出现401异常
@LdhCloudApplication
@EnableTransactionManagement
@MapperScan("com.liudehuang.system.mapper")
public class LdhServerSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LdhServerSystemApplication.class, args);
    }
}
