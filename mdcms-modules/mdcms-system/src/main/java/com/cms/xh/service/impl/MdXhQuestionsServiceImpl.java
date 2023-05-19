package com.cms.xh.service.impl;

import java.util.List;

import com.cms.common.core.exception.BaseException;
import com.cms.common.core.utils.DateUtils;
import com.cms.xh.domain.MdXhImgTable;
import com.cms.xh.domain.MdXhUsers;
import com.cms.xh.domain.vo.MdXhQuestionsVO;
import com.cms.xh.domain.vo.MdXhTopicTypeAndAnswerVO;
import com.cms.xh.mapper.MdXhImgTableMapper;
import com.cms.xh.mapper.MdXhTopicMapper;
import com.cms.xh.mapper.MdXhUsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cms.xh.mapper.MdXhQuestionsMapper;
import com.cms.xh.domain.MdXhQuestions;
import com.cms.xh.service.IMdXhQuestionsService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 问卷答题Service业务层处理
 *
 * @author lhy
 * @date 2023-05-08
 */
@Service
@Slf4j
public class MdXhQuestionsServiceImpl implements IMdXhQuestionsService {

    @Autowired
    private MdXhQuestionsMapper mdXhQuestionsMapper;

    @Autowired
    private MdXhUsersMapper mdXhUsersMapper;

    @Autowired
    private MdXhTopicMapper mdXhTopicMapper;

    @Autowired
    private MdXhImgTableMapper mdXhImgTableMapper;

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
    public List<MdXhQuestionsVO> selectMdXhQuestionsList(MdXhQuestionsVO mdXhQuestions) {
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

    /**
     * 判断用户是否能继续观看视频
     *
     * @param userId 用户 ID
     */
    public void isWatchVideo(Long userId) {
        MdXhUsers mdXhUsers = mdXhUsersMapper.selectMdXhUsersById(userId);
        if (mdXhUsers == null) {
            log.info("isWatchVideo:mdXhUsers is {}", mdXhUsers);
            throw new BaseException("查不到该用户");
        }
        if (mdXhUsers.getWatchCount() <= 3 || mdXhUsers.getWatchTime() <= 11400) {
            log.info("isWatchVideo:mdXhUsers.getWatchCount() is {},mdXhUsers.getWatchTime() is {}", mdXhUsers.getWatchCount(), mdXhUsers.getWatchTime());
            throw new BaseException("还可以观看视频，不能开始答题");
        }
    }

    /**
     * 用户提交题目
     *
     * @param mdQuestion 用户提交的题目
     * @return
     */
    @Override
    @Transactional
    public String addUserQuestions(List<MdXhQuestions> mdQuestion) {
        int result = mdXhQuestionsMapper.addUserQuestions(mdQuestion);
        if (result <= 0) {
            log.info("addUserQuestions:result is {}", result);
            throw new BaseException("提交题目异常");
        }
        // 遍历用户提交的题目和正确答案进行比较，进行判分
        MdXhTopicTypeAndAnswerVO allByTypeAndAnswer = null;
        for (MdXhQuestions mdXhQuestions : mdQuestion) {
            allByTypeAndAnswer = mdXhTopicMapper.getAllByTypeAndAnswer(mdXhQuestions.getTopicId());
            // type：1 - 选择题 + 1 分，2 - 填空题 + 2 分，3 - 主观题 + 3 分
            if (allByTypeAndAnswer.getType() == 1) {
                if (allByTypeAndAnswer.getAnswer().equals(mdXhQuestions.getUserAnswer())) {
                    int result1 = mdXhUsersMapper.updateUserScore(mdXhQuestions.getUserId(), 1L);
                    if (result1 <= 0) {
                        log.info("addUserQuestions:result1 is {}", result1);
                        throw new BaseException("计分异常");
                    }
                }
            }
            if (allByTypeAndAnswer.getType() == 2) {
                if (allByTypeAndAnswer.getAnswer().equals(mdXhQuestions.getUserAnswer())) {
                    int result1 = mdXhUsersMapper.updateUserScore(mdXhQuestions.getUserId(), 2L);
                    if (result1 <= 0) {
                        log.info("addUserQuestions:result1 is {}", result1);
                        throw new BaseException("计分异常");
                    }
                }
            }
            if (allByTypeAndAnswer.getType() == 3) {
                String[] answerSplits = allByTypeAndAnswer.getAnswer().split(",");
                for (String answerSplit : answerSplits) {
                    if (mdXhQuestions.getUserAnswer().contains(answerSplit)) {
                        int result1 = mdXhUsersMapper.updateUserScore(mdXhQuestions.getUserId(), 3L);
                        if (result1 <= 0) {
                            log.info("addUserQuestions:result1 is {}", result1);
                            throw new BaseException("计分异常");
                        }
                    }
                }
            }
        }
        Long userId = mdQuestion.get(0).getUserId();
        MdXhUsers byUserId = mdXhUsersMapper.getByUserId(userId);
            if (byUserId.getScore() >= 80) {
                MdXhImgTable mdXhImgTable = mdXhImgTableMapper.getAll();
                return mdXhImgTable.getImgUrl();
            }
        if (byUserId.getScore() <= 80 && byUserId.getNum() != 1) {
            int result1 = mdXhUsersMapper.updateByWatchCountAndNum(byUserId.getUserId());
            if (result1 <= 0) {
                log.info("addUserQuestions:result1 is {}", result1);
                throw new BaseException("补考功能异常");
            }
            return "不及格，可以补考 1 次";
        }
        if (byUserId.getScore() <= 80 && byUserId.getNum() == 1) {
            return "不合格，无法继续操作";
        }
        return "题目提交成功";
    }
}
