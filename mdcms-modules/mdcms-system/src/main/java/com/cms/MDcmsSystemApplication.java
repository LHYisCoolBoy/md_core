package com.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import com.cms.common.security.annotation.EnableCustomConfig;
import com.cms.common.security.annotation.EnableRyFeignClients;
import com.cms.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 系统模块
 *
 * @author mdcms  官方网站：www.mdcms.vip
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringCloudApplication
public class MDcmsSystemApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(MDcmsSystemApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
