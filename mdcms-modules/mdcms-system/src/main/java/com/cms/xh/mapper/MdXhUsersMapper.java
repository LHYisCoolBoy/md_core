package com.cms.xh.mapper;

import java.util.List;
import com.cms.xh.domain.MdXhUsers;
import org.springframework.stereotype.Repository;

/**
 * 用户信息Mapper接口
 * 
 * @author lhy
 * @date 2023-05-08
 */
public interface MdXhUsersMapper
{
    /**
     * 查询用户信息
     * 
     * @param id 用户信息ID
     * @return 用户信息
     */
    public MdXhUsers selectMdXhUsersById(Long id);

    /**
     * 查询用户信息列表
     * 
     * @param mdXhUsers 用户信息
     * @return 用户信息集合
     */
    public List<MdXhUsers> selectMdXhUsersList(MdXhUsers mdXhUsers);

    /**
     * 新增用户信息
     * 
     * @param mdXhUsers 用户信息
     * @return 结果
     */
    public int insertMdXhUsers(MdXhUsers mdXhUsers);

    /**
     * 修改用户信息
     * 
     * @param mdXhUsers 用户信息
     * @return 结果
     */
    public int updateMdXhUsers(MdXhUsers mdXhUsers);

    /**
     * 删除用户信息
     * 
     * @param id 用户信息ID
     * @return 结果
     */
    public int deleteMdXhUsersById(Long id);

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMdXhUsersByIds(Long[] ids);
}
