package com.hljycms.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.hljycms.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 文件服务
 * 
 * @author hljycms  官方网站：www.hljycms.com
 */
@EnableCustomSwagger2
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class HljycmsFileApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(HljycmsFileApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  文件服务模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
