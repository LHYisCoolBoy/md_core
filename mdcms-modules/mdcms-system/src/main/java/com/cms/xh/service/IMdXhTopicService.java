package com.cms.xh.service;

import java.util.List;
import com.cms.xh.domain.MdXhTopic;

/**
 * 题目Service接口
 * 
 * @author lhy
 * @date 2023-05-09
 */
public interface IMdXhTopicService 
{
    /**
     * 查询题目
     * 
     * @param id 题目ID
     * @return 题目
     */
    public MdXhTopic selectMdXhTopicById(Long id);

    /**
     * 查询题目列表
     * 
     * @param mdXhTopic 题目
     * @return 题目集合
     */
    public List<MdXhTopic> selectMdXhTopicList(MdXhTopic mdXhTopic);

    /**
     * 新增题目
     * 
     * @param mdXhTopic 题目
     * @return 结果
     */
    public int insertMdXhTopic(MdXhTopic mdXhTopic);

    /**
     * 修改题目
     * 
     * @param mdXhTopic 题目
     * @return 结果
     */
    public int updateMdXhTopic(MdXhTopic mdXhTopic);

    /**
     * 批量删除题目
     * 
     * @param ids 需要删除的题目ID
     * @return 结果
     */
    public int deleteMdXhTopicByIds(Long[] ids);

    /**
     * 删除题目信息
     * 
     * @param id 题目ID
     * @return 结果
     */
    public int deleteMdXhTopicById(Long id);

    /**
     * 获取所有题目信息
     * @return
     */
    List<MdXhTopic> getAll();
}
