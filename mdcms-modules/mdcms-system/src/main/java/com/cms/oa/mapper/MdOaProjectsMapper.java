package com.cms.oa.mapper;

import java.util.List;

import com.cms.oa.domain.MdOaProjects;
import com.cms.oa.domain.vo.MdOaProjectsVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 项目Mapper接口
 *
 * @author lhy
 * @date 2023-05-17
 */
@Repository
public interface MdOaProjectsMapper {
    /**
     * 查询项目
     *
     * @param id 项目ID
     * @return 项目
     */
    public MdOaProjects selectMdOaProjectsById(Long id);

    /**
     * 查询项目列表
     *
     * @param mdOaProjects 项目
     * @return 项目集合
     */
    public List<MdOaProjects> selectMdOaProjectsList(MdOaProjects mdOaProjects);

    /**
     * 新增项目
     *
     * @param mdOaProjects 项目
     * @return 结果
     */
    public int insertMdOaProjects(MdOaProjects mdOaProjects);

    /**
     * 修改项目
     *
     * @param mdOaProjects 项目
     * @return 结果
     */
    public int updateMdOaProjects(MdOaProjects mdOaProjects);

    /**
     * 删除项目
     *
     * @param id 项目ID
     * @return 结果
     */
    public int deleteMdOaProjectsById(Long id);

    /**
     * 批量删除项目
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMdOaProjectsByIds(Long[] ids);

    /**
     * 根据用户 ID 查询当前用户未完成的项目信息（我的待办）
     * 当查看我的待办页面的时候，传参当前登录的用户和是否完成字段默认是 0
     *
     * @return
     */
    List<MdOaProjectsVO> selectAllByUserIdAndIsComplete(MdOaProjects mdOaProjects);

    /**
     * 根据部门 ID 获取用户信息
     * @param mdOaProjects
     * @return
     */
    List<MdOaProjectsVO> selectAllByDeptId(MdOaProjects mdOaProjects);

    /**
     * 根据项目 ID 更新该项目的是否已完成字段为已完成
     *
     * @param mdOaProjects
     * @return
     */
    int updateIsCompleteById(MdOaProjects mdOaProjects);

    /**
     * 根据用户 ID 查询协同人是否包含自己，展示在消息部分
     *
     * @param userId
     * @return
     */
    int selectByCollaboratorId(@Param("userId") Long userId);
}
