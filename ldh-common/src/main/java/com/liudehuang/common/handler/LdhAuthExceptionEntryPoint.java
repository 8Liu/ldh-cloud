package com.liudehuang.common.handler;

import com.alibaba.fastjson.JSONObject;
import com.liudehuang.common.entity.LdhResponse;
import com.liudehuang.common.utils.LdhUtil;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理资源服务器异常：令牌不正确返回401
 */
public class LdhAuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        LdhResponse ldhResponse = new LdhResponse();
        LdhUtil.makeResponse(
                response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                HttpServletResponse.SC_UNAUTHORIZED, ldhResponse.message("token无效")
        );
    }
}