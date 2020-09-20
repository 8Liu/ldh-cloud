package com.liudehuang.gateway.filter;

import com.liudehuang.common.entity.LdhResponse;
import com.liudehuang.common.utils.LdhUtil;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LdhGatewayErrorFilter extends SendErrorFilter {
    @Override
    public Object run() {
        try {
            LdhResponse ldhResponse = new LdhResponse();
            //通过RequestContext获取到当前请求上下文，
            // 通过请求上下文可以获取到当前请求的服务名称serviceId和
            // 当前请求的异常对象ExceptionHolder
            RequestContext ctx = RequestContext.getCurrentContext();
            String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);

            ExceptionHolder exception = findZuulException(ctx.getThrowable());
            String errorCause = exception.getErrorCause();
            Throwable throwable = exception.getThrowable();
            String message = throwable.getMessage();
            message = StringUtils.isBlank(message) ? errorCause : message;
            ldhResponse = resolveExceptionMessage(message, serviceId, ldhResponse);

            HttpServletResponse response = ctx.getResponse();
            LdhUtil.makeResponse(
                    response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ldhResponse
            );
            log.error("Zull sendError：{}", ldhResponse.getMessage());
        } catch (Exception ex) {
            log.error("Zuul sendError", ex);
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }

    private LdhResponse resolveExceptionMessage(String message, String serviceId, LdhResponse ldhResponse) {
        if (StringUtils.containsIgnoreCase(message, "time out")) {
            return ldhResponse.message("请求" + serviceId + "服务超时");
        }
        if (StringUtils.containsIgnoreCase(message, "forwarding error")) {
            return ldhResponse.message(serviceId + "服务不可用");
        }
        return ldhResponse.message("Zuul请求" + serviceId + "服务异常");
    }
}
