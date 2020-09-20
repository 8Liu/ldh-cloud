package com.liudehuang.common.annotation;

import com.liudehuang.common.configure.LdhAuthExceptionConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LdhAuthExceptionConfigure.class)
public @interface EnableLdhAuthExceptionHandler {
}
