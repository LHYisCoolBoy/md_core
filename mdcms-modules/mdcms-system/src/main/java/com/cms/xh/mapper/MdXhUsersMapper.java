package com.cms.xh.mapper;

import java.util.List;

import com.cms.xh.domain.MdXhUsers;
import com.cms.xh.domain.vo.MdXhUsersVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户信息Mapper接口
 *
 * @author lhy
 * @date 2023-05-12
 */
@Repository
public interface MdXhUsersMapper {
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
    public List<MdXhUsersVO> selectMdXhUsersList(MdXhUsersVO mdXhUsers);

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

    /**
     * 根据用户 ID 累计用户观看次数
     *
     * @param userId 用户 ID
     * @return
     */
    int updateUserWatchCount(Long userId);

    /**
     * 根据用户 ID 累计用户观看时间
     *
     * @param userId    用户 ID
     * @param watchTime 用户观看时间
     * @return
     */
    int updateUserWatchTime(Long userId, Long watchTime);

    /**
     * 根据用户 ID 更新用户分数
     *
     * @param userId 用户 ID
     * @param score  分数
     * @return
     */
    int updateUserScore(@Param("userId") Long userId, @Param("score") Long score);

    /**
     * 根据用户 ID 查询分数内容
     *
     * @param userId
     * @return
     */
    MdXhUsers getByUserId(Long userId);

    /**
     * 根据用户 ID，把用户的观看次数重置为 2、观看时长和答题得分重置为 0，补考次数加 1
     *
     * @param userId
     * @return
     */
    int updateByWatchCountAndNum(Long userId);
}
