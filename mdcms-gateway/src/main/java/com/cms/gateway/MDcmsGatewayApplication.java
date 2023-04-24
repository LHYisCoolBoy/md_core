package com.cms.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 网关启动程序
 *
 * @author mdcms  官方网站：www.mdcms.com
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MDcmsGatewayApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(MDcmsGatewayApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  明德伟业网关启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
