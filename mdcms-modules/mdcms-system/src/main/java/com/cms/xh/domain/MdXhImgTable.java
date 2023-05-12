package com.cms.xh.domain;

import com.cms.common.core.annotation.Excel;
import com.cms.common.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 图片表
 *
 * @author lhy
 * @date 2023-05-09
 */
public class MdXhImgTable extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Excel(name = "主键")
    private Long id;

    /**
     * 题目类型
     */
    @Excel(name = "分数合格后的图片地址")
    private String imgUrl;

    /**
     * 逻辑删除 0 - 未删除，1 - 已删除
     */
    private Long isDelete;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setIsDelete(Long isDelete) {
        this.isDelete = isDelete;
    }

    public Long getIsDelete() {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("imgUrl", getImgUrl())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("isDelete", getIsDelete())
                .toString();
    }
}
