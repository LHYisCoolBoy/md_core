package com.cms.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import com.cms.common.security.annotation.EnableRyFeignClients;

/**
 * 认证授权中心
 *
 * @author mdcms  官方网站：www.mdcms.com
 */
@EnableRyFeignClients
@SpringCloudApplication
public class MDcmsAuthApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(MDcmsAuthApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  认证授权中心启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
