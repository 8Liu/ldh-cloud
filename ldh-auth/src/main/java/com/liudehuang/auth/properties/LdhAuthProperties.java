package com.liudehuang.auth.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:ldh-auth.properties"})
@ConfigurationProperties(prefix = "ldh.auth")
public class LdhAuthProperties {
    /**
     *
     */
    private LdhClientsProperties[] clients = {};
    /**
     * 用于指定access_token的有效时间，默认值为60 * 60 * 24秒
     */
    private int accessTokenValiditySeconds = 60 * 60 * 24;
    /**
     * refreshTokenValiditySeconds用于指定refresh_token的有效时间，默认值为60 * 60 * 24 * 7秒
     */
    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 7;

    /**
     * 验证码配置类
     */
    private LdhValidateCodeProperties code = new LdhValidateCodeProperties();

    /**
     * 免认证路径
     */
    private String anonUrl;
}
