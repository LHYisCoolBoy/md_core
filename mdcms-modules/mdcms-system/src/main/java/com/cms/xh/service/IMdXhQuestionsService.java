package com.cms.xh.service;

import java.util.List;

import com.cms.xh.domain.MdXhQuestions;
import com.cms.xh.domain.vo.MdXhQuestionsVO;

/**
 * 问卷答题Service接口
 *
 * @author lhy
 * @date 2023-05-08
 */
public interface IMdXhQuestionsService {
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
    public List<MdXhQuestionsVO> selectMdXhQuestionsList(MdXhQuestionsVO mdXhQuestions);

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
     * 批量删除问卷答题
     *
     * @param ids 需要删除的问卷答题ID
     * @return 结果
     */
    public int deleteMdXhQuestionsByIds(Long[] ids);

    /**
     * 删除问卷答题信息
     *
     * @param id 问卷答题ID
     * @return 结果
     */
    public int deleteMdXhQuestionsById(Long id);

    /**
     * 判断用户是否能继续观看视频
     *
     * @param userId 用户 ID
     */
    public void isWatchVideo(Long userId);

    /**
     * 用户提交题目
     *
     * @param mdQuestion 用户提交的题目
     * @return
     */
    String addUserQuestions(List<MdXhQuestions> mdQuestion);

}
