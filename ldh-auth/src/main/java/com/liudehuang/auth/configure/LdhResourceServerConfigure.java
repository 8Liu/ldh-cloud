package com.liudehuang.auth.configure;

import com.liudehuang.auth.properties.LdhAuthProperties;
import com.liudehuang.common.handler.LdhAccessDeniedHandler;
import com.liudehuang.common.handler.LdhAuthExceptionEntryPoint;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * LdhResourceServerConfigure用于处理非/oauth/开头的请求，
 * 其主要用于资源的保护，用于拦截所有的请求
 * 客户端只能通过OAuth2协议发放的令牌来从资源服务器中获取受保护的资源
 */
@Configuration
//开启资源服务器相关配置
@EnableResourceServer
public class LdhResourceServerConfigure extends ResourceServerConfigurerAdapter {

    @Autowired
    private LdhAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private LdhAuthExceptionEntryPoint exceptionEntryPoint;
    @Autowired
    private LdhAuthProperties properties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getAnonUrl(), ",");
        http.csrf().disable()//禁止跨域请求
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers(anonUrls).permitAll()
                .antMatchers("/**").authenticated()
                .and().httpBasic();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}
