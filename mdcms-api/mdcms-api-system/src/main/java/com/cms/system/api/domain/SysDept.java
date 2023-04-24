package com.cms.system.api.domain;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import com.cms.common.core.web.domain.BaseEntity;

/**
 * 部门表 sys_dept
 *
 * @author mdcms  官方网站：www.mdcms.com
 */
@Data
@ApiModel(value = "SysDept", description = "部门对象")
public class SysDept extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    @ApiModelProperty(value = "部门ID")
    private Long deptId;

    /**
     * 父部门ID
     */
    @ApiModelProperty(value = "上级部门ID")
    private Long parentId;

    /**
     * 部门人数
     */
    @ApiModelProperty(value = "部门人数")
    private int personNum;
    /**
     * 祖级列表
     */
    private String ancestors;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    private String deptName;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门职能描述")
    private String desc;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序")
    private String orderNum;

    /**
     * 负责人
     */
    @ApiModelProperty(value = "负责人")
    private String leader;

    /**
     * 负责人id
     */
    @ApiModelProperty(value = "负责人id")
    private String leaderId;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String phone;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 部门状态:0正常,1停用
     */
    @ApiModelProperty(value = "部门状态:0正常,1停用")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @ApiModelProperty(value = " 删除标志（0代表存在 2代表删除）")
    private String delFlag;

    /**
     * 父部门名称
     */
    @ApiModelProperty(value = " 父部门名称")
    private String parentName;

    /**
     * 子部门
     */
    @ApiModelProperty(value = " 子部门")
    private List<SysDept> children = new ArrayList<SysDept>();

    /**
     * 所属渠道
     */
    @ApiModelProperty(value = " 所属渠道")
    private Integer channelId;

    /**
     * 所属渠道
     */
    @ApiModelProperty(value = " 所属渠道")
    private String channelName;
}
