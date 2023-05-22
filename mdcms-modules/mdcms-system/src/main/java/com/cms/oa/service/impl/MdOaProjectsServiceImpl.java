package com.cms.oa.service.impl;

import java.util.List;

import com.cms.common.core.exception.BaseException;
import com.cms.common.core.utils.DateUtils;
import com.cms.oa.domain.vo.MdOaProjectsVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cms.oa.mapper.MdOaProjectsMapper;
import com.cms.oa.domain.MdOaProjects;
import com.cms.oa.service.IMdOaProjectsService;

/**
 * 项目Service业务层处理
 *
 * @author lhy
 * @date 2023-05-17
 */
@Service
@Slf4j
public class MdOaProjectsServiceImpl implements IMdOaProjectsService {
    @Autowired
    private MdOaProjectsMapper mdOaProjectsMapper;

    /**
     * 查询项目
     *
     * @param id 项目ID
     * @return 项目
     */
    @Override
    public MdOaProjects selectMdOaProjectsById(Long id) {
        return mdOaProjectsMapper.selectMdOaProjectsById(id);
    }

    /**
     * 查询项目列表
     *
     * @param mdOaProjects 项目
     * @return 项目
     */
    @Override
    public List<MdOaProjects> selectMdOaProjectsList(MdOaProjects mdOaProjects) {
        return mdOaProjectsMapper.selectMdOaProjectsList(mdOaProjects);
    }

    /**
     * 新增项目
     *
     * @param mdOaProjects 项目
     * @return 结果
     */
    @Override
    public int insertMdOaProjects(MdOaProjects mdOaProjects) {
        mdOaProjects.setCreateTime(DateUtils.getNowDate());
        return mdOaProjectsMapper.insertMdOaProjects(mdOaProjects);
    }

    /**
     * 修改项目
     *
     * @param mdOaProjects 项目
     * @return 结果
     */
    @Override
    public int updateMdOaProjects(MdOaProjects mdOaProjects) {
        mdOaProjects.setUpdateTime(DateUtils.getNowDate());
        return mdOaProjectsMapper.updateMdOaProjects(mdOaProjects);
    }

    /**
     * 批量删除项目
     *
     * @param ids 需要删除的项目ID
     * @return 结果
     */
    @Override
    public int deleteMdOaProjectsByIds(Long[] ids) {
        return mdOaProjectsMapper.deleteMdOaProjectsByIds(ids);
    }

    /**
     * 删除项目信息
     *
     * @param id 项目ID
     * @return 结果
     */
    @Override
    public int deleteMdOaProjectsById(Long id) {
        return mdOaProjectsMapper.deleteMdOaProjectsById(id);
    }

    /**
     * 根据用户 ID 查询当前用户未完成的项目信息（我的待办）
     *
     * @param mdOaProjects@return
     */
    @Override
    public List<MdOaProjectsVO> selectAllByUserIdAndIsComplete(MdOaProjects mdOaProjects) {
        if (mdOaProjects == null) {
            log.info("selectAllByUserIdAndIsComplete:mdOaProjects is {}", mdOaProjects);
            throw new BaseException("参数不能为空");
        }
        List<MdOaProjectsVO> mdOaProjectsVOList = mdOaProjectsMapper.selectAllByUserIdAndIsComplete(mdOaProjects);
        if (mdOaProjectsVOList == null || mdOaProjectsVOList.isEmpty()) {
            log.info("selectAllByUserIdAndIsComplete:mdOaProjectsVOList is {}", mdOaProjectsVOList);
            throw new BaseException("无数据");
        }
        return mdOaProjectsVOList;
    }


    /**
     * 根据项目 ID 更新该项目的是否已完成字段为已完成
     *
     * @param id
     * @return
     */
    @Override
    public int updateIsCompleteById(Long id) {
        if (id == null) {
            log.info("updateIsCompleteById:id is {}", id);
            throw new BaseException("参数不能为空");
        }
        return mdOaProjectsMapper.updateIsCompleteById(id);
    }

    /**
     * 根据用户 ID 查询协同人是否包含自己，展示在消息部分
     *
     * @param userId
     * @return
     */
    @Override
    public int selectByCollaboratorId(Long userId) {
        if (userId == null) {
            log.info("updateIsCompleteById:id is {}", userId);
            throw new BaseException("参数不能为空");
        }
        return mdOaProjectsMapper.selectByCollaboratorId(userId);
    }
}
