package com.liudehuang.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.liudehuang.common.entity.LdhConstant;
import com.liudehuang.common.entity.LdhResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LdhServerProtectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 从请求头中获取 Zuul Token
        String token = request.getHeader(LdhConstant.ZUUL_TOKEN_HEADER);
        String zuulToken = new String(Base64Utils.encode(LdhConstant.ZUUL_TOKEN_VALUE.getBytes()));
        // 校验 Zuul Token的正确性
        if (StringUtils.equals(zuulToken, token)) {
            return true;
        } else {
            LdhResponse ldhResponse = new LdhResponse();
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write(JSONObject.toJSONString(ldhResponse.message("请通过网关获取资源")));
            return false;
        }
    }
}