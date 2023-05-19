package com.cms.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.cms.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 文件服务
 *
 * @author mdcms  官方网站：www.mdcms.com
 */
@EnableCustomSwagger2
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MDcmsFileApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(MDcmsFileApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  网盘服务模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
