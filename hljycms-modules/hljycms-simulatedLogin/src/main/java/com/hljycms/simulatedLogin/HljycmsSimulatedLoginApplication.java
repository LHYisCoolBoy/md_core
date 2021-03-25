package com.hljycms.simulatedLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import com.hljycms.common.security.annotation.EnableCustomConfig;
import com.hljycms.common.security.annotation.EnableRyFeignClients;
import com.hljycms.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 爬虫
 * 
 * @author hljycms  官方网站：www.hljycms.com
 */
@EnableCustomConfig
@EnableCustomSwagger2   
@EnableRyFeignClients
@SpringCloudApplication
public class HljycmsSimulatedLoginApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(HljycmsSimulatedLoginApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  simulatedLogin模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
