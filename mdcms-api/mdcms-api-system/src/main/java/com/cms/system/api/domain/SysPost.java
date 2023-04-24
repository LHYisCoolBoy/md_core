package com.cms.system.api.domain;

import com.cms.common.core.annotation.Excel;
import com.cms.common.core.annotation.Excel.ColumnType;
import com.cms.common.core.web.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Size;

/**
 * 岗位表 sys_post
 *
 * @author mdcms  官方网站：www.mdcms.com
 */

@ApiModel(value = "SysPost",description = "岗位对象")
public class SysPost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 岗位序号 */
    @Excel(name = "岗位序号", cellType = ColumnType.NUMERIC)
    @ApiModelProperty(value = "岗位id")
    private Long postId;

    /** 岗位编码*/
    @Excel(name = "岗位编码")
    @ApiModelProperty(value = "岗位编码")
    private String postCode;

    /** 岗位名称 */
    @Excel(name = "岗位名称")
    @ApiModelProperty(value = "岗位名称")
    private String postName;

    /** 直属上级 */
    @Excel(name = "直属上级")
    @ApiModelProperty(value = "直属上级")
    private String leaderName;

    /** 直属上级 */
    @Excel(name = "直属上级")
    @ApiModelProperty(value = "直属上级")
    private String leaderId;

    /** 职能描述 */
    @Excel(name = "职能描述")
    @ApiModelProperty(value = "职能描述")
    private String desc;

    /** 岗位排序 */
    @Excel(name = "岗位排序")
    @ApiModelProperty(value = "岗位排序")
    private String postSort;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    @ApiModelProperty(value = "状态（0正常 1停用")
    private String status;

    /** 用户是否存在此岗位标识 默认不存在 */
    private boolean flag = false;

    //@NotBlank(message = "岗位id不能为空")
    public Long getPostId()
    {
        return postId;
    }

    public void setPostId(Long postId)
    {
        this.postId = postId;
    }

    //@NotBlank(message = "岗位编码不能为空")
    @Size(min = 0, max = 64, message = "岗位编码长度不能超过64个字符")
    public String getPostCode()
    {
        return postCode;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

    //@NotBlank(message = "岗位名称不能为空")
    @Size(min = 0, max = 50, message = "岗位名称长度不能超过50个字符")
    public String getPostName()
    {
        return postName;
    }

    public void setPostName(String postName)
    {
        this.postName = postName;
    }

    public String getLeaderName()
    {
        return leaderName;
    }

    public void setLeaderName(String leaderName)
    {
        this.leaderName = leaderName;
    }

    public String getLeaderId()
    {
        return leaderId;
    }

    public void setLeaderId(String leaderId)
    {
        this.leaderId = leaderId;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    //@NotBlank(message = "显示顺序不能为空")
    public String getPostSort()
    {
        return postSort;
    }

    public void setPostSort(String postSort)
    {
        this.postSort = postSort;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("postId", getPostId())
            .append("postCode", getPostCode())
            .append("postName", getPostName())
            .append("postSort", getPostSort())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
