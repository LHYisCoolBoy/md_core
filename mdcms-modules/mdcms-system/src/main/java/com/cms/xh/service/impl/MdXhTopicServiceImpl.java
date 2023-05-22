package com.cms.xh.service.impl;

import java.util.List;

import com.cms.common.core.exception.BaseException;
import com.cms.common.core.utils.DateUtils;
import com.cms.common.log.annotation.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cms.xh.mapper.MdXhTopicMapper;
import com.cms.xh.domain.MdXhTopic;
import com.cms.xh.service.IMdXhTopicService;

/**
 * 题目Service业务层处理
 *
 * @author lhy
 * @date 2023-05-09
 */
@Service
@Slf4j
public class MdXhTopicServiceImpl implements IMdXhTopicService {
    @Autowired
    private MdXhTopicMapper mdXhTopicMapper;

    /**
     * 查询题目
     *
     * @param id 题目ID
     * @return 题目
     */
    @Override
    public MdXhTopic selectMdXhTopicById(Long id) {
        return mdXhTopicMapper.selectMdXhTopicById(id);
    }

    /**
     * 查询题目列表
     *
     * @param mdXhTopic 题目
     * @return 题目
     */
    @Override
    public List<MdXhTopic> selectMdXhTopicList(MdXhTopic mdXhTopic) {
        return mdXhTopicMapper.selectMdXhTopicList(mdXhTopic);
    }

    /**
     * 新增题目
     *
     * @param mdXhTopic 题目
     * @return 结果
     */
    @Override
    public int insertMdXhTopic(MdXhTopic mdXhTopic) {
        mdXhTopic.setCreateTime(DateUtils.getNowDate());
        return mdXhTopicMapper.insertMdXhTopic(mdXhTopic);
    }

    /**
     * 修改题目
     *
     * @param mdXhTopic 题目
     * @return 结果
     */
    @Override
    public int updateMdXhTopic(MdXhTopic mdXhTopic) {
        mdXhTopic.setUpdateTime(DateUtils.getNowDate());
        return mdXhTopicMapper.updateMdXhTopic(mdXhTopic);
    }

    /**
     * 批量删除题目
     *
     * @param ids 需要删除的题目ID
     * @return 结果
     */
    @Override
    public int deleteMdXhTopicByIds(Long[] ids) {
        return mdXhTopicMapper.deleteMdXhTopicByIds(ids);
    }

    /**
     * 删除题目信息
     *
     * @param id 题目ID
     * @return 结果
     */
    @Override
    public int deleteMdXhTopicById(Long id) {
        return mdXhTopicMapper.deleteMdXhTopicById(id);
    }

    /**
     * 获取哦所有题目信息
     *
     * @return
     */
    @Override
    public List<MdXhTopic> getAll() {
        List<MdXhTopic> all = mdXhTopicMapper.getAll();
        if (all == null) {
            log.info("MdXhTopicServiceImpl:getAll:all is {}", all);
            throw new BaseException("查询失败，结果为空");
        }
        return all;
    }
}
