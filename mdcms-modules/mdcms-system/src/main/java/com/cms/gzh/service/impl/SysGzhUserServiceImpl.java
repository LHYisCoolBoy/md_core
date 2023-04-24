package com.cms.gzh.service.impl;

import com.cms.common.core.utils.DateUtils;
import com.cms.gzh.domain.SysGzhUser;
import com.cms.gzh.mapper.SysGzhUserMapper;
import com.cms.gzh.service.SysGzhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cms.system.mapper.SysUserMapper;

import java.util.List;

/**
 * 公众号用户名Service业务层处理
 *
 * @author lhy
 * @date 2023-04-10
 */
@Service
public class SysGzhUserServiceImpl implements SysGzhUserService {
    @Autowired
    private SysGzhUserMapper sysUserMapper;

    /**
     * 查询公众号用户名
     *
     * @param id 公众号用户名ID
     * @return 公众号用户名
     */
    @Override
    public SysGzhUser selectSysUserById(Long id) {
        return sysUserMapper.selectSysUserById(id);
    }

    /**
     * 查询公众号用户名列表
     *
     * @param sysUser 公众号用户名
     * @return 公众号用户名
     */
    @Override
    public List<SysGzhUser> selectSysUserList(SysGzhUser sysUser) {
        return sysUserMapper.selectSysUserList(sysUser);
    }

    /**
     * 新增公众号用户名
     *
     * @param sysUser 公众号用户名
     * @return 结果
     */
    @Override
    public int insertSysUser(SysGzhUser sysUser) {
        return sysUserMapper.insertSysUser(sysUser);
    }

    /**
     * 修改公众号用户名
     *
     * @param sysUser 公众号用户名
     * @return 结果
     */
    @Override
    public int updateSysUser(SysGzhUser sysUser) {
        sysUser.setUpdateTime(DateUtils.getNowDate());
        return sysUserMapper.updateSysUser(sysUser);
    }

    /**
     * 批量删除公众号用户名
     *
     * @param ids 需要删除的公众号用户名ID
     * @return 结果
     */
    @Override
    public int deleteSysUserByIds(Long[] ids) {
        return sysUserMapper.deleteSysUserByIds(ids);
    }

    /**
     * 删除公众号用户名信息
     *
     * @param id 公众号用户名ID
     * @return 结果
     */
    @Override
    public int deleteSysUserById(Long id) {
        return sysUserMapper.deleteSysUserById(id);
    }
}
