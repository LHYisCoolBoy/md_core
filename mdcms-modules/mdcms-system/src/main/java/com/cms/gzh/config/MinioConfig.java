package com.cms.gzh.config;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class MinioConfig {

    @Bean
    public MinioClient minioClient() {
        System.out.println("minioClient注册");
        MinioClient build = MinioClient.builder()
                .endpoint("http://123.56.170.190:9198")
                .credentials("zJMyumMs5mqcBbyC", "ZLYtHh8tVkqaDKGbxxxqQREwSNiYJG5H")
                .build();
        System.out.println("注册成功");
        return build;
    }
}
