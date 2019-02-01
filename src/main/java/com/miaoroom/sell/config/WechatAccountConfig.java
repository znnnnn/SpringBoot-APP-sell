package com.miaoroom.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @create: 2019/2/1 22:52
 * @author: znnnnn
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String  mpAppId;
    private String mpAppSecret;

}
