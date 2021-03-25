package com.hljycms.job;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import com.hljycms.common.security.annotation.EnableCustomConfig;
import com.hljycms.common.security.annotation.EnableRyFeignClients;
import com.hljycms.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 定时任务
 * 
 * @author hljycms  官方网站：www.hljycms.com
 */
@EnableCustomConfig
@EnableCustomSwagger2   
@EnableRyFeignClients
@SpringCloudApplication
public class HljycmsJobApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(HljycmsJobApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  定时任务模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
