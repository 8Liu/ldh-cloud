package com.liudehuang.common.annotation;

import com.liudehuang.common.configure.LdhServerProtectConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LdhServerProtectConfigure.class)
public @interface EnableLdhServerProtect {

}