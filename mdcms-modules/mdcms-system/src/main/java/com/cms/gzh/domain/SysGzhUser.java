package com.cms.gzh.domain;

import java.util.Date;

import com.cms.common.core.web.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.cms.common.core.annotation.Excel;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 公众号用户名对象 sys_user
 *
 * @author lhy
 * @date 2023-04-10
 */
public class SysGzhUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String userName;

    /** 注册时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "注册时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date registerTime;

    /** 今日日期 */
    private Date notTime;

    /** 头像地址 */
    @Excel(name = "头像地址")
    private String avatar;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phone;

    /** 性别 */
    @Excel(name = "性别")
    private Long sex;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 逻辑删除（0 - 未删除，1 - 已删除） */
    @Excel(name = "逻辑删除", readConverterExp = "0=,-=,未=删除，1,-=,已=删除")
    private Long isDelete;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setRegisterTime(Date registerTime)
    {
        this.registerTime = registerTime;
    }

    public Date getRegisterTime()
    {
        return registerTime;
    }
    public void setNotTime(Date notTime)
    {
        this.notTime = notTime;
    }

    public Date getNotTime()
    {
        return notTime;
    }
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getAvatar()
    {
        return avatar;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setSex(Long sex)
    {
        this.sex = sex;
    }

    public Long getSex()
    {
        return sex;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
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
            .append("userName", getUserName())
            .append("registerTime", getRegisterTime())
            .append("notTime", getNotTime())
            .append("avatar", getAvatar())
            .append("phone", getPhone())
            .append("sex", getSex())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
