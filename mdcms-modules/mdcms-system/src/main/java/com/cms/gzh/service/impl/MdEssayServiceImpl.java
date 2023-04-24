package com.cms.gzh.service.impl;

import java.util.List;

import com.cms.common.core.utils.DateUtils;
import com.cms.system.api.domain.IdNameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cms.gzh.mapper.MdEssayMapper;
import com.cms.gzh.domain.MdEssay;
import com.cms.gzh.service.IMdEssayService;

/**
 * 文章Service业务层处理
 *
 * @author lhy
 * @date 2023-04-19
 */
@Service
public class MdEssayServiceImpl implements IMdEssayService {
    @Autowired
    private MdEssayMapper mdEssayMapper;

    /**
     * 查询文章
     *
     * @param id 文章ID
     * @return 文章
     */
    @Override
    public MdEssay selectMdEssayById(Integer id) {
        return mdEssayMapper.selectMdEssayById(id);
    }

    /**
     * 查询文章列表
     *
     * @param mdEssay 文章
     * @return 文章
     */
    @Override
    public List<MdEssay> selectMdEssayList(MdEssay mdEssay) {
        return mdEssayMapper.selectMdEssayList(mdEssay);
    }

    /**
     * 新增文章
     *
     * @param mdEssay 文章
     * @return 结果
     */
    @Override
    public int insertMdEssay(MdEssay mdEssay) {
        mdEssay.setCreateTime(DateUtils.getNowDate());
        return mdEssayMapper.insertMdEssay(mdEssay);
    }

    /**
     * 修改文章
     *
     * @param mdEssay 文章
     * @return 结果
     */
    @Override
    public int updateMdEssay(MdEssay mdEssay) {
        mdEssay.setUpdateTime(DateUtils.getNowDate());
        return mdEssayMapper.updateMdEssay(mdEssay);
    }

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的文章ID
     * @return 结果
     */
    @Override
    public int deleteMdEssayByIds(Integer[] ids) {
        return mdEssayMapper.deleteMdEssayByIds(ids);
    }

    /**
     * 删除文章信息
     *
     * @param id 文章ID
     * @return 结果
     */
    @Override
    public int deleteMdEssayById(Integer id) {
        return mdEssayMapper.deleteMdEssayById(id);
    }

    @Override
    public List<IdNameVo> nameList() {
        List<IdNameVo> returnList = mdEssayMapper.nameList();
        return returnList;
    }
}
