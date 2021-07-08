package com.fancv.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
@Slf4j
public class MytokenConfig {

    @Value("${appkey:default_value}")
    private String appkey;

    @Value("${appSecret:123424213default_value}")
    private String appSecret;

    private String token;

    public String getToken() {

        if (null==token) {
            log.info("调用更新了token");
            updateToken();
        }
        return token;

    }

    public void updateToken() {
        this.token = new StringBuffer(appkey).append(appSecret).toString().toLowerCase(Locale.ROOT);
        log.info("更新了token");
    }

}
