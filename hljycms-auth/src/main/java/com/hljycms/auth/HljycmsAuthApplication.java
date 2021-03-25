package com.hljycms.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import com.hljycms.common.security.annotation.EnableRyFeignClients;

/**
 * 认证授权中心
 * 
 * @author hljycms  官方网站：www.hljycms.com
 */
@EnableRyFeignClients
@SpringCloudApplication
public class HljycmsAuthApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(HljycmsAuthApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  认证授权中心启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
