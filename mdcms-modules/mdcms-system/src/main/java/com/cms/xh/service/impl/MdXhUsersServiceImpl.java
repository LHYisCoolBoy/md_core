package com.cms.xh.service.impl;

import java.util.List;
import com.cms.common.core.utils.DateUtils;
import com.cms.xh.domain.MdXhUsers;
import com.cms.xh.domain.vo.MdXhUsersVO;
import com.cms.xh.mapper.MdXhUsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cms.xh.service.IMdXhUsersService;

/**
 * 用户信息Service业务层处理
 *
 * @author lhy
 * @date 2023-05-08
 */
@Service
public class MdXhUsersServiceImpl implements IMdXhUsersService
{
    @Autowired
    private MdXhUsersMapper mdXhUsersMapper;

    /**
     * 查询用户信息
     *
     * @param id 用户信息ID
     * @return 用户信息
     */
    @Override
    public MdXhUsers selectMdXhUsersById(Long id)
    {
        return mdXhUsersMapper.selectMdXhUsersById(id);
    }

    /**
     * 查询用户信息列表
     *
     * @param mdXhUsers 用户信息
     * @return 用户信息
     */
    @Override
    public List<MdXhUsersVO> selectMdXhUsersList(MdXhUsersVO mdXhUsers)
    {
        return mdXhUsersMapper.selectMdXhUsersList(mdXhUsers);
    }

    /**
     * 新增用户信息
     *
     * @param mdXhUsers 用户信息
     * @return 结果
     */
    @Override
    public int insertMdXhUsers(MdXhUsers mdXhUsers)
    {
        mdXhUsers.setCreateTime(DateUtils.getNowDate());
        return mdXhUsersMapper.insertMdXhUsers(mdXhUsers);
    }

    /**
     * 修改用户信息
     *
     * @param mdXhUsers 用户信息
     * @return 结果
     */
    @Override
    public int updateMdXhUsers(MdXhUsers mdXhUsers)
    {
        mdXhUsers.setUpdateTime(DateUtils.getNowDate());
        return mdXhUsersMapper.updateMdXhUsers(mdXhUsers);
    }

    /**
     * 批量删除用户信息
     *
     * @param ids 需要删除的用户信息ID
     * @return 结果
     */
    @Override
    public int deleteMdXhUsersByIds(Long[] ids)
    {
        return mdXhUsersMapper.deleteMdXhUsersByIds(ids);
    }

    /**
     * 删除用户信息信息
     *
     * @param id 用户信息ID
     * @return 结果
     */
    @Override
    public int deleteMdXhUsersById(Long id)
    {
        return mdXhUsersMapper.deleteMdXhUsersById(id);
    }
}
