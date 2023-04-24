package com.cms.gzh.service;

import java.util.List;

import com.cms.gzh.domain.SysGzhUser;
import com.cms.gzh.domain.SysGzhUser;

/**
 * 公众号用户名Service接口
 *
 * @author lhy
 * @date 2023-04-10
 */
public interface SysGzhUserService
{
    /**
     * 查询公众号用户名
     *
     * @param id 公众号用户名ID
     * @return 公众号用户名
     */
    public SysGzhUser selectSysUserById(Long id);

    /**
     * 查询公众号用户名列表
     *
     * @param sysUser 公众号用户名
     * @return 公众号用户名集合
     */
    public List<SysGzhUser> selectSysUserList(SysGzhUser sysUser);

    /**
     * 新增公众号用户名
     *
     * @param sysUser 公众号用户名
     * @return 结果
     */
    public int insertSysUser(SysGzhUser sysUser);

    /**
     * 修改公众号用户名
     *
     * @param sysUser 公众号用户名
     * @return 结果
     */
    public int updateSysUser(SysGzhUser sysUser);

    /**
     * 批量删除公众号用户名
     *
     * @param ids 需要删除的公众号用户名ID
     * @return 结果
     */
    public int deleteSysUserByIds(Long[] ids);

    /**
     * 删除公众号用户名信息
     *
     * @param id 公众号用户名ID
     * @return 结果
     */
    public int deleteSysUserById(Long id);
}
