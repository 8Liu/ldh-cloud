package com.liudehuang.common.annotation;

import com.liudehuang.common.configure.LdhLettuceRedisConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LdhLettuceRedisConfigure.class)
public @interface EnableLdhLettuceRedis {

}