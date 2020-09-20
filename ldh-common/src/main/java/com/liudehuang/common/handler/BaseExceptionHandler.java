package com.liudehuang.common.handler;

import com.liudehuang.common.entity.LdhResponse;
import com.liudehuang.common.exception.LdhAuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public LdhResponse handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return new LdhResponse().message("系统内部异常");
    }

    @ExceptionHandler(value = LdhAuthException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public LdhResponse handleFebsAuthException(LdhAuthException e) {
        log.error("系统错误", e);
        return new LdhResponse().message(e.getMessage());
    }
    
    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public LdhResponse handleAccessDeniedException(){
        return new LdhResponse().message("没有权限访问该资源");
    }
}