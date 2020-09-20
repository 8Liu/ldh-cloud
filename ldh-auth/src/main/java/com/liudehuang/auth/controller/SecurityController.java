package com.liudehuang.auth.controller;

import com.liudehuang.common.entity.LdhResponse;
import com.liudehuang.common.exception.LdhAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class SecurityController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("oauth/test")
    public String testOauth() {
        return "oauth";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @DeleteMapping("signout")
    public LdhResponse signout(HttpServletRequest request) throws LdhAuthException {
        String authorization = request.getHeader("Authorization");
        String token = StringUtils.replace(authorization, "bearer ", "");
        LdhResponse febsResponse = new LdhResponse();
        if (!consumerTokenServices.revokeToken(token)) {
            throw new LdhAuthException("退出登录失败");
        }
        return febsResponse.message("退出登录成功");
    }
}