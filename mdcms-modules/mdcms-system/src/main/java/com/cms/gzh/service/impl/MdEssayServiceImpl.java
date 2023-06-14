package com.cms.gzh.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.cms.common.core.annotation.Excel;
import com.cms.common.core.utils.DateUtils;
import com.cms.gzh.domain.MdEssayDTO;
import com.cms.gzh.domain.MdEssayVO;
import com.cms.gzh.domain.Test01;
import com.cms.gzh.mapper.Test01Mapper;
import com.cms.system.api.domain.IdNameVo;
import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cms.gzh.mapper.MdEssayMapper;
import com.cms.gzh.domain.MdEssay;
import com.cms.gzh.service.IMdEssayService;

import javax.annotation.Resource;

/**
 * 文章Service业务层处理
 *
 * @author lhy
 * @date 2023-04-19
 */
@Service
public class MdEssayServiceImpl implements IMdEssayService {
    @Resource
    private MdEssayMapper mdEssayMapper;

    @Autowired
    private Test01Mapper test01Mapper;

    @Resource
    private MinioClient minioClient;

    // 存储桶名称
    public final static String bucketName = "my-bucket";

    /**
     * 查询文章
     *
     * @param id 文章ID
     * @return 文章
     */
    @Override
    public MdEssayVO selectMdEssayById(Integer id) {
        MdEssayVO mdEssayVO = mdEssayMapper.selectMdEssayById(id);
        HttpClient aDefault = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(mdEssayVO.getText());
        String responseBody = "";
        try {
            ClassicHttpResponse response = (ClassicHttpResponse) aDefault.execute(httpGet);
            responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            System.out.println("responseBody " + responseBody);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        MdEssayVO mdEssayVO1 = new MdEssayVO();
        mdEssayVO1.setEssayTitle(mdEssayVO.getEssayTitle());
        mdEssayVO1.setEssaySubtitle(mdEssayVO.getEssaySubtitle());
        mdEssayVO1.setEssayText(mdEssayVO.getEssayText());
        mdEssayVO1.setInformationClassify(mdEssayVO.getInformationClassify());
        mdEssayVO1.setSort(mdEssayVO.getSort());
        mdEssayVO1.setText(responseBody);
        mdEssayVO1.setStatus(mdEssayVO.getStatus());
        mdEssayVO1.setClickNum(mdEssayVO.getClickNum());

        return mdEssayVO1;
    }

    /**
     * 查询文章列表
     *
     * @param mdEssay 文章
     * @return 文章
     */
    @Override
    public List<MdEssayVO> selectMdEssayList(MdEssay mdEssay) {
        return mdEssayMapper.selectMdEssayList(mdEssay);
    }

    /**
     * 新增文章
     *
     * @param mdEssay 文章
     * @return 结果
     */
    @Override
    public int insertMdEssay(MdEssayDTO mdEssay) {
        mdEssay.setCreateTime(DateUtils.getNowDate());
        String url = this.uploadFile01(mdEssay.getEssayTitle(), mdEssay.getText());
        Test01 test01 = new Test01();
        test01.setText(url);
        int i = test01Mapper.addText(test01);
        if (i <= 0) {
            System.out.println("添加失败");
        }
        Test01 text = test01Mapper.getText(test01);
        MdEssay mdEssay1 = new MdEssay();
        mdEssay1.setEssayTitle(mdEssay.getEssayTitle());
        mdEssay1.setEssaySubtitle(mdEssay.getEssaySubtitle());
        mdEssay1.setEssayText(mdEssay.getEssayText());
        mdEssay1.setInformationClassify(mdEssay.getInformationClassify());
        mdEssay1.setCoverImage(mdEssay.getCoverImage());
        mdEssay1.setSort(mdEssay.getSort());
        mdEssay1.setTextId(text.getId());
        mdEssay1.setStatus(mdEssay.getStatus());

        return mdEssayMapper.insertMdEssay(mdEssay1);
    }


    /**
     * 修改文章
     *
     * @param mdEssay 文章
     * @return 结果
     */
    @Override
    public int updateMdEssay(MdEssayDTO mdEssay) {
        mdEssay.setUpdateTime(DateUtils.getNowDate());
        MdEssay mdEssay2 = mdEssayMapper.selectMdEssayById01(mdEssay.getId());
        Test01 test01 = new Test01();
        test01.setId(mdEssay2.getTextId());
        test01.setText(mdEssay.getText());
        System.out.println("test01.getId() " + test01.getId());
        System.out.println("mdEssay2.getTextId() " + mdEssay2.getTextId());
        int i = test01Mapper.updateText(test01);
        if (i <= 0) {
            System.out.println("修改失败");
        }
        Test01 text = test01Mapper.getText(test01);
        MdEssay mdEssay1 = new MdEssay();
        mdEssay1.setEssayTitle(mdEssay.getEssayTitle());
        mdEssay1.setEssaySubtitle(mdEssay.getEssaySubtitle());
        mdEssay1.setEssayText(mdEssay.getEssayText());
        mdEssay1.setInformationClassify(mdEssay.getInformationClassify());
        mdEssay1.setCoverImage(mdEssay.getCoverImage());
        mdEssay1.setSort(mdEssay.getSort());
        mdEssay1.setTextId(text.getId());
        mdEssay1.setStatus(mdEssay.getStatus());
        mdEssay1.setId(mdEssay.getId());

        return mdEssayMapper.updateMdEssay(mdEssay1);
    }

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的文章ID
     * @return 结果
     */
    @Override
    public int deleteMdEssayByIds(Integer[] ids) {
        return mdEssayMapper.deleteMdEssayByIds(ids);
    }

    /**
     * 删除文章信息
     *
     * @param id 文章ID
     * @return 结果
     */
    @Override
    public int deleteMdEssayById(Integer id) {
        return mdEssayMapper.deleteMdEssayById(id);
    }

    @Override
    public List<IdNameVo> nameList() {
        List<IdNameVo> returnList = mdEssayMapper.nameList();
        return returnList;
    }

    public String uploadFile01(String essayTitle, String text) {
        try {
//            String bucketName = "my-bucket"; // 存储桶的名称
            String objectKey = essayTitle + ".html"; // 对象的名称即对象键

            // 将富文本内容转换为字节数组
            String richText = text;
            byte[] content = richText.getBytes(StandardCharsets.UTF_8);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(content);

            // 上传对象并设置元数据信息
//            MinioClient.builder().build().putObject(bucketName, objectKey, content, content.length, null, null, "application/octet-stream");
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(objectKey)
                    .stream(byteArrayInputStream, content.length, -1)
                    .contentType("application/octet-stream")
                    .build());


            // 获取对象的 URL 地址
            String test = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                    .bucket(bucketName)
                    .object(objectKey)
                    .expiry(60 * 60 * 24)
                    .method(Method.GET)
                    .build());

            System.out.println("test " + test);

            return test;
        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
        }
        return null;
    }
}
