package com.liudehuang.common.handler;

import com.liudehuang.common.entity.LdhResponse;
import com.liudehuang.common.utils.LdhUtil;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理资源服务器异常：用户无权限返回403
 */
public class LdhAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        LdhResponse ldhResponse = new LdhResponse();
        LdhUtil.makeResponse(
                response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                HttpServletResponse.SC_FORBIDDEN, ldhResponse.message("没有权限访问该资源"));
    }
}