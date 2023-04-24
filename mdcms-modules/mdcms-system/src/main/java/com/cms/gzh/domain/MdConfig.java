package com.cms.gzh.domain;

import com.cms.common.core.annotation.Excel;
import com.cms.common.core.web.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 推荐配置对象 md_config
 *
 * @author lhy
 * @date 2023-04-21
 */
@Data
public class MdConfig extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 标签
     */
    @Excel(name = "分类id")
    private String isId;

    /**
     * 标签
     */
    @Excel(name = "标签")
    private String tag;

    /**
     * 封面类型
     */
    @Excel(name = "封面类型")
    private Long type;

    /**
     * 素材地址
     */
    @Excel(name = "素材地址")
    private String url;

    /**
     * 文章
     */
    @Excel(name = "文章")
    private Long essayId;

    /**
     * 轮播次数
     */
    @Excel(name = "轮播次数")
    private Integer rotationNum;

    /**
     * 资讯标题（可为空）
     */
    private String infoTitle;

    /**
     * 是否启用
     */
    private Long isDelete;
}
