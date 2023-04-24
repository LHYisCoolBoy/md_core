package com.cms.modules.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 监控中心
 *
 * @author mdcms  官方网站：www.mdcms.com
 */
@EnableAdminServer
@SpringCloudApplication
public class MDcmsMonitorApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(MDcmsMonitorApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  监控中心启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
