package com.cms.xh.mapper;

import java.util.List;

import com.cms.system.domain.md.MdQuestion;
import com.cms.xh.domain.MdXhQuestions;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 问卷答题Mapper接口
 *
 * @author lhy
 * @date 2023-05-08
 */
@Repository
public interface MdXhQuestionsMapper {
    /**
     * 查询问卷答题
     *
     * @param id 问卷答题ID
     * @return 问卷答题
     */
    public MdXhQuestions selectMdXhQuestionsById(Long id);

    /**
     * 查询问卷答题列表
     *
     * @param mdXhQuestions 问卷答题
     * @return 问卷答题集合
     */
    public List<MdXhQuestions> selectMdXhQuestionsList(MdXhQuestions mdXhQuestions);

    /**
     * 新增问卷答题
     *
     * @param mdXhQuestions 问卷答题
     * @return 结果
     */
    public int insertMdXhQuestions(MdXhQuestions mdXhQuestions);

    /**
     * 修改问卷答题
     *
     * @param mdXhQuestions 问卷答题
     * @return 结果
     */
    public int updateMdXhQuestions(MdXhQuestions mdXhQuestions);

    /**
     * 删除问卷答题
     *
     * @param id 问卷答题ID
     * @return 结果
     */
    public int deleteMdXhQuestionsById(Long id);

    /**
     * 批量删除问卷答题
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMdXhQuestionsByIds(Long[] ids);

    /**
     * 用户提交题目
     *
     * @param mdQuestion 用户提交的题目
     * @return
     */
    int addUserQuestions(List<MdXhQuestions> mdQuestion);

    /**
     * 根据用户 ID 删除已提交的题目
     * @param userId 用户 ID
     * @return
     */
    int deleteByUserId(Long userId);
}
