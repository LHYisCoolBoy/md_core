package com.cms.gzh.domain;

import com.cms.common.core.annotation.Excel;
import com.cms.common.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 文章对象 md_essay
 *
 * @author lhy
 * @date 2023-04-19
 */
public class MdEssay extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 标题 */
    @Excel(name = "标题")
    private String essayTitle;

    /** 副标题 */
    private String essaySubtitle;

    /** 资讯简介 */
    private String essayText;

    /** 资讯分类 */
    @Excel(name = "资讯分类")
    private String informationClassify;

    /** 封面图片 */
    @Excel(name = "封面图片")
    private String coverImage;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

    /** 正文 */
    private Long textId;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 浏览量 */
    @Excel(name = "浏览量")
    private Long clickNum;

    /** 逻辑删除（0 - 未删除，1 - 已删除） */
    private Long isDelete;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setEssayTitle(String essayTitle)
    {
        this.essayTitle = essayTitle;
    }

    public String getEssayTitle()
    {
        return essayTitle;
    }
    public void setEssaySubtitle(String essaySubtitle)
    {
        this.essaySubtitle = essaySubtitle;
    }

    public String getEssaySubtitle()
    {
        return essaySubtitle;
    }
    public void setEssayText(String essayText)
    {
        this.essayText = essayText;
    }

    public String getEssayText()
    {
        return essayText;
    }
    public void setInformationClassify(String informationClassify)
    {
        this.informationClassify = informationClassify;
    }

    public String getInformationClassify()
    {
        return informationClassify;
    }
    public void setCoverImage(String coverImage)
    {
        this.coverImage = coverImage;
    }

    public String getCoverImage()
    {
        return coverImage;
    }
    public void setSort(Integer sort)
    {
        this.sort = sort;
    }

    public Integer getSort()
    {
        return sort;
    }


    public Long getTextId() {
        return textId;
    }

    public void setTextId(Long textId) {
        this.textId = textId;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setClickNum(Long clickNum)
    {
        this.clickNum = clickNum;
    }

    public Long getClickNum()
    {
        return clickNum;
    }
    public void setIsDelete(Long isDelete)
    {
        this.isDelete = isDelete;
    }

    public Long getIsDelete()
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("essayTitle", getEssayTitle())
            .append("essaySubtitle", getEssaySubtitle())
            .append("essayText", getEssayText())
            .append("informationClassify", getInformationClassify())
            .append("coverImage", getCoverImage())
            .append("sort", getSort())
            .append("textId", getTextId())
            .append("status", getStatus())
            .append("clickNum", getClickNum())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
