package com.cms.oa.domain;

import com.cms.common.core.annotation.Excel;
import com.cms.common.core.web.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 已办对象 md_oa_completed
 *
 * @author lhy
 * @date 2023-05-17
 */
public class MdOaCompleted extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @Excel(name = "主键")
    private Long id;

    /** 用户 ID */
    @Excel(name = "用户 ID")
    private Long userId;

    /** 部门 ID */
    @Excel(name = "部门 ID")
    private Long deptId;

    /** 项目 ID */
    @Excel(name = "项目 ID")
    private Long projectId;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String imgUrl;

    /** 视频地址 */
    @Excel(name = "视频地址")
    private String videoUrl;

    /** 文件地址 */
    @Excel(name = "文件地址")
    private String fileUrl;

    /** 逻辑删除（0 - 未删除，1 - 已删除） */
    private Long isDelete;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    public void setProjectId(Long projectId)
    {
        this.projectId = projectId;
    }

    public Long getProjectId()
    {
        return projectId;
    }
    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }
    public void setVideoUrl(String videoUrl)
    {
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl()
    {
        return videoUrl;
    }
    public void setFileUrl(String fileUrl)
    {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl()
    {
        return fileUrl;
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
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("projectId", getProjectId())
            .append("imgUrl", getImgUrl())
            .append("videoUrl", getVideoUrl())
            .append("fileUrl", getFileUrl())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
