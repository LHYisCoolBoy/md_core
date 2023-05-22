package com.cms.oa.domain.vo;

import com.cms.common.core.annotation.Excel;
import com.cms.common.core.web.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

/**
 * 项目对象 md_oa_projects
 *
 * @author lhy
 * @date 2023-05-17
 */
public class MdOaProjectsVO extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户 ID
     */
    private Long userId;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 部门 ID
     */
    private Long deptId;

    /**
     * 部门昵称
     */
    private String deptName;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 协同人 ID
     */
    private Long collaboratorId;

    /**
     * 协同人名称
     */
    private String collaboratorName;

    /**
     * 协同人部门 ID
     */
    private Long collaboratorDeptId;

    /**
     * 协同人部门名称
     */
    private String collaboratorDeptName;

    /**
     * 紧急程度
     */
    private String urgency;

    /**
     * 项目描述
     */
    private String description;

    /**
     * 项目的开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    /**
     * 项目预计的结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    /**
     * 费用出处
     */
    private String expenseSource;

    /**
     * 费用金额
     */
    private String expenseAmount;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 视频地址
     */
    private String videoUrl;

    /**
     * 文件地址
     */
    private String fileUrl;

    /**
     * 是否已支付（0 - 未支付，1 - 已支付）
     */
    private Long isPayment;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCollaboratorId(Long collaboratorId) {
        this.collaboratorId = collaboratorId;
    }

    public Long getCollaboratorId() {
        return collaboratorId;
    }

    public void setCollaboratorDeptId(Long collaboratorDeptId) {
        this.collaboratorDeptId = collaboratorDeptId;
    }

    public Long getCollaboratorDeptId() {
        return collaboratorDeptId;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setExpenseSource(String expenseSource) {
        this.expenseSource = expenseSource;
    }

    public String getExpenseSource() {
        return expenseSource;
    }

    public void setExpenseAmount(String expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseAmount() {
        return expenseAmount;
    }

    public void setIsPayment(Long isPayment) {
        this.isPayment = isPayment;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCollaboratorName() {
        return collaboratorName;
    }

    public void setCollaboratorName(String collaboratorName) {
        this.collaboratorName = collaboratorName;
    }

    public String getCollaboratorDeptName() {
        return collaboratorDeptName;
    }

    public void setCollaboratorDeptName(String collaboratorDeptName) {
        this.collaboratorDeptName = collaboratorDeptName;
    }

    public Long getIsPayment() {
        return isPayment;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("nickName", getNickName())
                .append("deptId", getDeptId())
                .append("deptName", getDeptName())
                .append("name", getName())
                .append("collaboratorId", getCollaboratorId())
                .append("collaboratorName", getCollaboratorName())
                .append("collaboratorDeptId", getCollaboratorDeptId())
                .append("collaboratorDeptName", getCollaboratorDeptName())
                .append("urgency", getUrgency())
                .append("description", getDescription())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("imgUrl", getImgUrl())
                .append("videoUrl", getVideoUrl())
                .append("fileUrl", getFileUrl())
                .append("expenseSource", getExpenseSource())
                .append("expenseAmount", getExpenseAmount())
                .append("isPayment", getIsPayment())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
