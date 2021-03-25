package com.hljycms.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 网关启动程序
 * 
 * @author hljycms  官方网站：www.hljycms.com
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class HljycmsGatewayApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(HljycmsGatewayApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  亨利嘉业网关启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
