package com.cms.xh.service.impl;

import java.util.List;

import com.cms.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cms.xh.mapper.MdXhQuestionsMapper;
import com.cms.xh.domain.MdXhQuestions;
import com.cms.xh.service.IMdXhQuestionsService;

import javax.annotation.Resource;

/**
 * 问卷答题Service业务层处理
 *
 * @author lhy
 * @date 2023-05-08
 */
@Service
public class MdXhQuestionsServiceImpl implements IMdXhQuestionsService {

    @Autowired
    private MdXhQuestionsMapper mdXhQuestionsMapper;

    /**
     * 查询问卷答题
     *
     * @param id 问卷答题ID
     * @return 问卷答题
     */
    @Override
    public MdXhQuestions selectMdXhQuestionsById(Long id) {
        return mdXhQuestionsMapper.selectMdXhQuestionsById(id);
    }

    /**
     * 查询问卷答题列表
     *
     * @param mdXhQuestions 问卷答题
     * @return 问卷答题
     */
    @Override
    public List<MdXhQuestions> selectMdXhQuestionsList(MdXhQuestions mdXhQuestions) {
        return mdXhQuestionsMapper.selectMdXhQuestionsList(mdXhQuestions);
    }

    /**
     * 新增问卷答题
     *
     * @param mdXhQuestions 问卷答题
     * @return 结果
     */
    @Override
    public int insertMdXhQuestions(MdXhQuestions mdXhQuestions) {
        mdXhQuestions.setCreateTime(DateUtils.getNowDate());
        return mdXhQuestionsMapper.insertMdXhQuestions(mdXhQuestions);
    }

    /**
     * 修改问卷答题
     *
     * @param mdXhQuestions 问卷答题
     * @return 结果
     */
    @Override
    public int updateMdXhQuestions(MdXhQuestions mdXhQuestions) {
        mdXhQuestions.setUpdateTime(DateUtils.getNowDate());
        return mdXhQuestionsMapper.updateMdXhQuestions(mdXhQuestions);
    }

    /**
     * 批量删除问卷答题
     *
     * @param ids 需要删除的问卷答题ID
     * @return 结果
     */
    @Override
    public int deleteMdXhQuestionsByIds(Long[] ids) {
        return mdXhQuestionsMapper.deleteMdXhQuestionsByIds(ids);
    }

    /**
     * 删除问卷答题信息
     *
     * @param id 问卷答题ID
     * @return 结果
     */
    @Override
    public int deleteMdXhQuestionsById(Long id) {
        return mdXhQuestionsMapper.deleteMdXhQuestionsById(id);
    }
}
