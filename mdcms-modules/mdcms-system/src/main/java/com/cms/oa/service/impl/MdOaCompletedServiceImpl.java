package com.cms.oa.service.impl;

import java.util.List;
import com.cms.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cms.oa.mapper.MdOaCompletedMapper;
import com.cms.oa.domain.MdOaCompleted;
import com.cms.oa.service.IMdOaCompletedService;

/**
 * 已办Service业务层处理
 *
 * @author lhy
 * @date 2023-05-17
 */
@Service
public class MdOaCompletedServiceImpl implements IMdOaCompletedService
{
    @Autowired
    private MdOaCompletedMapper mdOaCompletedMapper;

    /**
     * 查询已办
     *
     * @param id 已办ID
     * @return 已办
     */
    @Override
    public MdOaCompleted selectMdOaCompletedById(Long id)
    {
        return mdOaCompletedMapper.selectMdOaCompletedById(id);
    }

    /**
     * 查询已办列表
     *
     * @param mdOaCompleted 已办
     * @return 已办
     */
    @Override
    public List<MdOaCompleted> selectMdOaCompletedList(MdOaCompleted mdOaCompleted)
    {
        return mdOaCompletedMapper.selectMdOaCompletedList(mdOaCompleted);
    }

    /**
     * 新增已办
     *
     * @param mdOaCompleted 已办
     * @return 结果
     */
    @Override
    public int insertMdOaCompleted(MdOaCompleted mdOaCompleted)
    {
        mdOaCompleted.setCreateTime(DateUtils.getNowDate());
        return mdOaCompletedMapper.insertMdOaCompleted(mdOaCompleted);
    }

    /**
     * 修改已办
     *
     * @param mdOaCompleted 已办
     * @return 结果
     */
    @Override
    public int updateMdOaCompleted(MdOaCompleted mdOaCompleted)
    {
        mdOaCompleted.setUpdateTime(DateUtils.getNowDate());
        return mdOaCompletedMapper.updateMdOaCompleted(mdOaCompleted);
    }

    /**
     * 批量删除已办
     *
     * @param ids 需要删除的已办ID
     * @return 结果
     */
    @Override
    public int deleteMdOaCompletedByIds(Long[] ids)
    {
        return mdOaCompletedMapper.deleteMdOaCompletedByIds(ids);
    }

    /**
     * 删除已办信息
     *
     * @param id 已办ID
     * @return 结果
     */
    @Override
    public int deleteMdOaCompletedById(Long id)
    {
        return mdOaCompletedMapper.deleteMdOaCompletedById(id);
    }
}
