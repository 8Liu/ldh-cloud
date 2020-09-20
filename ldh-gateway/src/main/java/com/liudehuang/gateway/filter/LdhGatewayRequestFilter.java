package com.liudehuang.gateway.filter;

import com.liudehuang.common.entity.LdhConstant;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class LdhGatewayRequestFilter extends ZuulFilter {
    /**
     * zuul过滤器有四种：
     * PRE：PRE过滤器用于将请求路径与配置的路由规则进行匹配，以找到需要转发的目标地址，并做一些前置加工，比如请求的校验等
     * ROUTING：ROUTING过滤器用于将外部请求转发到具体服务实例上去；
     * POST：POST过滤器用于将微服务的响应信息返回到客户端，这个过程种可以对返回数据进行加工处理
     * ERROR：上述的过程发生异常后将调用ERROR过滤器。ERROR过滤器捕获到异常后需要将异常信息返回给客户端，所以最终还是会调用POST过滤器
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 6;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);
        HttpServletRequest request = ctx.getRequest();
        String host = request.getRemoteHost();
        String method = request.getMethod();
        String uri = request.getRequestURI();

        log.info("请求URI：{}，HTTP Method：{}，请求IP：{}，ServerId：{}", uri, method, host, serviceId);

        byte[] token = Base64Utils.encode(LdhConstant.ZUUL_TOKEN_VALUE.getBytes());
        ctx.addZuulRequestHeader(LdhConstant.ZUUL_TOKEN_HEADER, new String(token));
        return null;
    }
}
