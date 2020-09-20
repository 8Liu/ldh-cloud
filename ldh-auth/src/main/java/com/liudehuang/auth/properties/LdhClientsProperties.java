package com.liudehuang.auth.properties;

import lombok.Data;

@Data
public class LdhClientsProperties {
    /**
     * client对应client_id
     */
    private String client;
    /**
     * secret对应client_secret
     */
    private String secret;
    private String grantType = "password,authorization_code,refresh_token";
    private String scope = "all";
}
