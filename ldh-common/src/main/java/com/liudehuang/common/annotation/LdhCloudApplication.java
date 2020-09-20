package com.liudehuang.common.annotation;

import com.liudehuang.common.selector.LdhCloudApplicationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LdhCloudApplicationSelector.class)
public @interface LdhCloudApplication {

}