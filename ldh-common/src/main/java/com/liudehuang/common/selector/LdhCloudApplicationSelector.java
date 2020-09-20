package com.liudehuang.common.selector;

import com.liudehuang.common.configure.LdhAuthExceptionConfigure;
import com.liudehuang.common.configure.LdhOAuth2FeignConfigure;
import com.liudehuang.common.configure.LdhServerProtectConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class LdhCloudApplicationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                LdhAuthExceptionConfigure.class.getName(),
                LdhOAuth2FeignConfigure.class.getName(),
                LdhServerProtectConfigure.class.getName()
        };
    }
}