package com.cms.gzh.service.impl;

import java.util.List;

import com.cms.common.core.annotation.Excel;
import com.cms.common.core.utils.DateUtils;
import com.cms.gzh.domain.MdEssayDTO;
import com.cms.gzh.domain.MdEssayVO;
import com.cms.gzh.domain.Test01;
import com.cms.gzh.mapper.Test01Mapper;
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

    @Autowired
    private Test01Mapper test01Mapper;

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
    public List<MdEssayVO> selectMdEssayList(MdEssay mdEssay) {
        return mdEssayMapper.selectMdEssayList(mdEssay);
    }

    /**
     * 新增文章
     *
     * @param mdEssay 文章
     * @return 结果
     */
    @Override
    public int insertMdEssay(MdEssayDTO mdEssay) {
        mdEssay.setCreateTime(DateUtils.getNowDate());
        Test01 test01 = new Test01();
        test01.setText(mdEssay.getText());
        int i = test01Mapper.addText(test01);
        if (i <= 0) {
            System.out.println("添加失败");
        }
        Test01 text = test01Mapper.getText(test01);
        MdEssay mdEssay1 = new MdEssay();
        mdEssay1.setEssayTitle(mdEssay.getEssayTitle());
        mdEssay1.setEssaySubtitle(mdEssay.getEssaySubtitle());
        mdEssay1.setEssayText(mdEssay.getEssayText());
        mdEssay1.setInformationClassify(mdEssay.getInformationClassify());
        mdEssay1.setCoverImage(mdEssay.getCoverImage());
        mdEssay1.setSort(mdEssay.getSort());
        mdEssay1.setTextId(text.getId());
        mdEssay1.setStatus(mdEssay.getStatus());

        return mdEssayMapper.insertMdEssay(mdEssay1);
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
