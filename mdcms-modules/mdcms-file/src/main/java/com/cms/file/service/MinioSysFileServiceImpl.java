package com.cms.file.service;

import com.cms.file.config.MinioConfig;
import com.cms.file.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;

/**
 * Minio 文件存储
 *
 * @author mdcms  官方网站：www.mdcms.com
 */
@Service
public class MinioSysFileServiceImpl implements ISysFileService {
    @Autowired
    private MinioConfig minioConfig;

    @Autowired
    private MinioClient client;

    /**
     * 本地文件上传接口
     *
     * @param file 上传的文件
     * @return 访问地址
     * @throws Exception
     */
    public String uploadFile(MultipartFile file, String type) throws Exception {
        /*
        String fileName = FileUploadUtils.extractFilename(file);
        PutObjectArgs args = PutObjectArgs.builder()
                .bucket(minioConfig.getBucketName())
                .object(fileName)
                .stream(file.getInputStream(), file.getSize(), -1)
//                .contentType(file.getContentType())
                .contentType("image/jpg")
                .build();
        client.putObject(args);
        return minioConfig.getUrl() + "/" + minioConfig.getBucketName() + "/" + fileName;
        */
        return null;
    }

}
