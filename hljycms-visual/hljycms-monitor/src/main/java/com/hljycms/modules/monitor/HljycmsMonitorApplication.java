package com.hljycms.modules.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 监控中心
 * 
 * @author hljycms  官方网站：www.hljycms.com
 */
@EnableAdminServer
@SpringCloudApplication
public class HljycmsMonitorApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(HljycmsMonitorApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  监控中心启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
