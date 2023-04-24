package com.mdcms.advertisement;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import com.cms.common.security.annotation.EnableCustomConfig;
import com.cms.common.security.annotation.EnableRyFeignClients;
import com.cms.common.swagger.annotation.EnableCustomSwagger2;

/**
 * Advertisement模块
 *
 * @author mdcms  官方网站：www.mdcms.com
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringCloudApplication
public class mdcmsAdvertisementApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(mdcmsAdvertisementApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  Advertisement模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
