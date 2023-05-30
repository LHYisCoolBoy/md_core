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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 项目预计的结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
     * 客户部门名称
     */
    private String customerDepartmentName;

    /**
     * 客户 - 联系人
     */
    private String customerContactPerson;

    /**
     * 客户 - 联系电话
     */
    private String customerContactPhone;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 供应商联系人
     */
    private String supplierContactPerson;

    /**
     * 供应商联系人电话
     */
    private String supplierContactPhone;

    /**
     * 供应物资名称
     */
    private String materialName;

    /**
     * 供应物资数量
     */
    private String materialQuantity;

    /**
     * 供应物资价格
     */
    private String materialPrice;

    /**
     * 供应商合同
     */
    private String contract;

    /**
     * 项目分类
     */
    private Integer projectCategory;

    /**
     * 项目难点预测
     */
    private String difficultyForecast;

    /**
     * 需要总经理协调推进的问题
     */
    private String managerCooperationRequired;

    /**
     * 是否第一次接触
     */
    private Integer firstContact;

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

    /**
     * 是否已完成（0 - 未开始，1 - 已开始，2 - 已完成）
     */
    private Long isComplete;

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

    public Long getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Long isComplete) {
        this.isComplete = isComplete;
    }

    public String getCustomerDepartmentName() {
        return customerDepartmentName;
    }

    public void setCustomerDepartmentName(String customerDepartmentName) {
        this.customerDepartmentName = customerDepartmentName;
    }

    public String getCustomerContactPerson() {
        return customerContactPerson;
    }

    public void setCustomerContactPerson(String customerContactPerson) {
        this.customerContactPerson = customerContactPerson;
    }

    public String getCustomerContactPhone() {
        return customerContactPhone;
    }

    public void setCustomerContactPhone(String customerContactPhone) {
        this.customerContactPhone = customerContactPhone;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierContactPerson() {
        return supplierContactPerson;
    }

    public void setSupplierContactPerson(String supplierContactPerson) {
        this.supplierContactPerson = supplierContactPerson;
    }

    public String getSupplierContactPhone() {
        return supplierContactPhone;
    }

    public void setSupplierContactPhone(String supplierContactPhone) {
        this.supplierContactPhone = supplierContactPhone;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialQuantity() {
        return materialQuantity;
    }

    public void setMaterialQuantity(String materialQuantity) {
        this.materialQuantity = materialQuantity;
    }

    public String getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(String materialPrice) {
        this.materialPrice = materialPrice;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Integer getProjectCategory() {
        return projectCategory;
    }

    public void setProjectCategory(Integer projectCategory) {
        this.projectCategory = projectCategory;
    }

    public String getDifficultyForecast() {
        return difficultyForecast;
    }

    public void setDifficultyForecast(String difficultyForecast) {
        this.difficultyForecast = difficultyForecast;
    }

    public String getManagerCooperationRequired() {
        return managerCooperationRequired;
    }

    public void setManagerCooperationRequired(String managerCooperationRequired) {
        this.managerCooperationRequired = managerCooperationRequired;
    }

    public Integer getFirstContact() {
        return firstContact;
    }

    public void setFirstContact(Integer firstContact) {
        this.firstContact = firstContact;
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
                .append("isComplete", getIsComplete())
                .append("customerDepartmentName", getCustomerDepartmentName())
                .append("customerContactPerson", getCustomerContactPerson())
                .append("customerContactPhone", getCustomerContactPhone())
                .append("supplierName", getSupplierName())
                .append("supplierContactPerson", getSupplierContactPerson())
                .append("materialName", getMaterialName())
                .append("materialQuantity", getMaterialQuantity())
                .append("supplierContactPhone", getSupplierContactPhone())
                .append("materialPrice", getMaterialPrice())
                .append("contract", getContract())
                .append("projectCategory", getProjectCategory())
                .append("difficultyForecast", getDifficultyForecast())
                .append("managerCooperationRequired", getManagerCooperationRequired())
                .append("firstContact", getFirstContact())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
