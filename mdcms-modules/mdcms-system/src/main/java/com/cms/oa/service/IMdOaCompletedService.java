package com.cms.oa.service;

import java.util.List;
import com.cms.oa.domain.MdOaCompleted;

/**
 * 已办Service接口
 * 
 * @author lhy
 * @date 2023-05-17
 */
public interface IMdOaCompletedService 
{
    /**
     * 查询已办
     * 
     * @param id 已办ID
     * @return 已办
     */
    public MdOaCompleted selectMdOaCompletedById(Long id);

    /**
     * 查询已办列表
     * 
     * @param mdOaCompleted 已办
     * @return 已办集合
     */
    public List<MdOaCompleted> selectMdOaCompletedList(MdOaCompleted mdOaCompleted);

    /**
     * 新增已办
     * 
     * @param mdOaCompleted 已办
     * @return 结果
     */
    public int insertMdOaCompleted(MdOaCompleted mdOaCompleted);

    /**
     * 修改已办
     * 
     * @param mdOaCompleted 已办
     * @return 结果
     */
    public int updateMdOaCompleted(MdOaCompleted mdOaCompleted);

    /**
     * 批量删除已办
     * 
     * @param ids 需要删除的已办ID
     * @return 结果
     */
    public int deleteMdOaCompletedByIds(Long[] ids);

    /**
     * 删除已办信息
     * 
     * @param id 已办ID
     * @return 结果
     */
    public int deleteMdOaCompletedById(Long id);
}
