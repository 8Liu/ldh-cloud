package com.liudehuang.common.configure;

import com.liudehuang.common.handler.LdhAccessDeniedHandler;
import com.liudehuang.common.handler.LdhAuthExceptionEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * 处理资源服务器异常的配置
 */
public class LdhAuthExceptionConfigure {
    /**
     * 用户无权限返回403
     * 当微服务系统的Spring IOC容器中没有名称为accessDeniedHandler的Bean的时候，
     * 就将LdhAccessDeniedHandler注册为一个Bean
     * 这样做的好处在于，子系统可以自定义自个儿的资源服务器异常处理器，覆盖我们在ldh-common通用模块里定义的
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public LdhAccessDeniedHandler accessDeniedHandler() {
        return new LdhAccessDeniedHandler();
    }

    /**
     * 用户token错误
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public LdhAuthExceptionEntryPoint authenticationEntryPoint() {
        return new LdhAuthExceptionEntryPoint();
    }
}