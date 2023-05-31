package com.cms.oa.service.impl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cms.common.core.exception.BaseException;
import com.cms.common.core.utils.DateUtils;
import com.cms.oa.domain.MdOaCompleted;
import com.cms.oa.domain.vo.MdOaProjectsVO;
import com.cms.oa.mapper.MdOaCompletedMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cms.oa.mapper.MdOaProjectsMapper;
import com.cms.oa.domain.MdOaProjects;
import com.cms.oa.service.IMdOaProjectsService;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private MdOaCompletedMapper mdOaCompletedMapper;

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
    @Transactional
    @Override
    public int insertMdOaProjects(MdOaProjects mdOaProjects) {
        mdOaProjects.setCreateTime(DateUtils.getNowDate());
        int result1 = mdOaProjectsMapper.insertMdOaProjects(mdOaProjects);
        if (result1 <= 0) {
            log.info("MdOaProjectsServiceImpl:insertMdOaProjects:result1 is {}", result1);
            throw new BaseException("添加失败");
        }
        return result1;
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
        int result = mdOaProjectsMapper.updateMdOaProjects(mdOaProjects);
        if (result <= 0) {
            log.info("MdOaProjectsServiceImpl:updateMdOaProjects:result is {}", result);
            return -1;
        }
        MdOaCompleted mdOaCompleted = new MdOaCompleted();
        mdOaCompleted.setId(mdOaProjects.getId());
        mdOaCompleted.setUserId(mdOaProjects.getUserId());
        mdOaCompleted.setDeptId(mdOaProjects.getDeptId());
        return mdOaCompletedMapper.updateMdOaCompleted(mdOaCompleted);
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
            return new ArrayList<>();
        }
        return mdOaProjectsVOList;
    }


    /**
     * 根据项目 ID 更新该项目的是否已完成字段为已完成
     *
     * @param mdOaProjects
     * @return
     */
    @Transactional
    @Override
    public int updateIsCompleteById(MdOaProjects mdOaProjects) {
        if (mdOaProjects == null) {
            log.info("updateIsCompleteById:mdOaProjects is {}", mdOaProjects);
            throw new BaseException("参数不能为空");
        }
        int result = mdOaProjectsMapper.updateIsCompleteById(mdOaProjects);
        if (result != 1) {
            log.info("updateIsCompleteById:result is {}", result);
            throw new BaseException("数据完成失败");
        }
        MdOaProjects mdOaProjects1 = this.selectMdOaProjectsById(mdOaProjects.getId());
        MdOaCompleted newMdOaCompleted = new MdOaCompleted();
        newMdOaCompleted.setUserId(mdOaProjects1.getUserId());
        newMdOaCompleted.setDeptId(mdOaProjects1.getDeptId());
        newMdOaCompleted.setProjectId(mdOaProjects.getId());
        return mdOaCompletedMapper.insertMdOaCompleted(newMdOaCompleted);
    }

    /**
     * 根据项目 ID 更新是否已支付字段
     * @param mdOaProjects
     * @return
     */
    @Override
    public int updateIsPaymentById(MdOaProjects mdOaProjects) {
        if (mdOaProjects == null) {
            log.info("updateIsPaymentById:mdOaProjects is {}", mdOaProjects);
            throw new BaseException("参数不能为空");
        }
        int result = mdOaProjectsMapper.updateIsPaymentById(mdOaProjects);
        if (result != 1) {
            log.info("updateIsCompleteById:result is {}", result);
            throw new BaseException("数据完成失败");
        }
        return result;
    }

    /**
     * 根据用户 ID 查询协同人是否包含自己并且项目是未完成的，展示在消息部分
     *
     * @param userId
     * @return
     */
    @Override
    public int selectByCollaboratorIdCount(Long userId) {
        if (userId == null) {
            log.info("updateIsCompleteById:id is {}", userId);
            throw new BaseException("参数不能为空");
        }
        return mdOaProjectsMapper.selectByCollaboratorIdCount(userId);
    }

    /**
     * 根据部门 ID 获取用户信息
     *
     * @param mdOaProjects
     * @return
     */
    @Override
    public List<MdOaProjectsVO> selectAllByDeptId(MdOaProjects mdOaProjects) {
        if (mdOaProjects == null) {
            log.info("MdOaProjectsServiceImpl:mdOaProjects is {}", mdOaProjects);
            throw new BaseException("参数不能为空");
        }
        List<MdOaProjectsVO> mdOaProjectsVOS = mdOaProjectsMapper.selectAllByDeptId(mdOaProjects);
        if (mdOaProjectsVOS == null || mdOaProjectsVOS.isEmpty()) {
            log.info("updateIsCompleteById:mdOaProjectsVOS is {}", mdOaProjectsVOS);
            return new ArrayList<>();
        }
        return mdOaProjectsVOS;
    }

    /**
     * 根据用户 ID 和是否已支付来查询所有项目信息
     *
     * @param mdOaProjects
     * @return
     */
    @Override
    public List<MdOaProjectsVO> selectAllByCollaboratorId(MdOaProjects mdOaProjects) {
        if (mdOaProjects == null) {
            log.info("MdOaProjectsServiceImpl:selectAllByCollaboratorId:mdOaProjects is {}", mdOaProjects);
            throw new BaseException("参数不能为空");
        }
        List<MdOaProjectsVO> mdOaProjectsVOS = mdOaProjectsMapper.selectAllByCollaboratorId(mdOaProjects);
        if (mdOaProjectsVOS == null || mdOaProjectsVOS.isEmpty()) {
            log.info("MdOaProjectsServiceImpl:selectAllByCollaboratorId:mdOaProjectsVOS is {}", mdOaProjectsVOS);
            return new ArrayList<>();
        }
        return mdOaProjectsVOS;
    }

    private Long getPhaseDifferenceDays(Date startTime, Date endTime) {
        LocalDateTime startDateTime = startTime.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        LocalDateTime endDateTime = endTime.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        return Duration.between(startDateTime, endDateTime).toDays();
    }
}
