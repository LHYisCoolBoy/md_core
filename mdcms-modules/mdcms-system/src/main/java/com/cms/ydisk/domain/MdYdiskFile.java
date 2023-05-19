package com.cms.ydisk.domain;

import java.util.Date;

import com.cms.common.core.web.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.cms.common.core.annotation.Excel;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 捷电网盘对象 md_ydisk_file
 *
 * @author LK
 * @date 2023-05-19
 */
public class MdYdiskFile extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 项目名
     */
    @Excel(name = "项目名")
    private String name;

    /**
     * 文件地址
     */
    @Excel(name = "文件地址")
    private String url;

    /**
     * 上传时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM - dd")
    private Date time;

    /**
     * 部门id
     */
    @Excel(name = "部门id")
    private Long deptId;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("url", getUrl())
                .append("time", getTime())
                .append("deptId", getDeptId())
                .append("userId", getUserId())
                .toString();
    }
}
