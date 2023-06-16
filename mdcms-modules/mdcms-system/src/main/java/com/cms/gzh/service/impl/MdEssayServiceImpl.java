package com.cms.gzh.service.impl;

import com.cms.common.core.utils.DateUtils;
import com.cms.gzh.domain.MdEssay;
import com.cms.gzh.domain.dto.MdEssayDto;
import com.cms.gzh.domain.vo.MdEssayVo;
import com.cms.gzh.domain.Test01;
import com.cms.gzh.mapper.MdEssayMapper;
import com.cms.gzh.mapper.Test01Mapper;
import com.cms.gzh.service.IMdEssayService;
import com.cms.system.api.domain.IdNameVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章Service业务层处理
 *
 * @author lhy
 * @date 2023-04-19
 */
@Service
@Slf4j
public class MdEssayServiceImpl implements IMdEssayService {
    @Resource
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
    public MdEssayVo selectMdEssayById(Integer id) {
        MdEssayVo mdEssayVO = mdEssayMapper.selectMdEssayById(id);
        return mdEssayVO;
    }

    /**
     * 查询文章列表
     *
     * @param mdEssay 文章
     * @return 文章
     */
    @Override
    public List<MdEssayVo> selectMdEssayList(MdEssay mdEssay) {
        return mdEssayMapper.selectMdEssayList(mdEssay);
    }

    /**
     * 新增文章
     *
     * @param mdEssay 文章
     * @return 结果
     */
    @Override
    public int insertMdEssay(MdEssayDto mdEssay) {
        mdEssay.setCreateTime(DateUtils.getNowDate());
        Integer sortMax = 0;
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
        if (mdEssay.getSort() == null) {
            sortMax = mdEssayMapper.getSortMax();
            sortMax += 1;
            mdEssay1.setSort(sortMax);
        } else {
            mdEssay1.setSort(mdEssay.getSort());
        }
        mdEssay1.setTextId(text.getId());
        mdEssay1.setStatus(mdEssay.getStatus());
        mdEssay1.setId(mdEssay.getId());
        mdEssay1.setClickNum(mdEssay.getClickNum());

        return mdEssayMapper.insertMdEssay(mdEssay1);
    }

    /**
     * 修改文章
     *
     * @param mdEssay 文章
     * @return 结果
     */
    @Override
    public int updateMdEssay(MdEssayDto mdEssay) {
        mdEssay.setUpdateTime(DateUtils.getNowDate());
        MdEssay mdEssay2 = mdEssayMapper.selectMdEssayById01(mdEssay.getId());
        Test01 test01 = new Test01();
        test01.setId(mdEssay2.getTextId());
        test01.setText(mdEssay.getText());
        int i = test01Mapper.updateText(test01);
        if (i <= 0) {
            log.info("修改富文本失败");
        }
        MdEssay mdEssay1 = new MdEssay();
        mdEssay1.setEssayTitle(mdEssay.getEssayTitle());
        mdEssay1.setEssaySubtitle(mdEssay.getEssaySubtitle());
        mdEssay1.setEssayText(mdEssay.getEssayText());
        mdEssay1.setInformationClassify(mdEssay.getInformationClassify());
        mdEssay1.setCoverImage(mdEssay.getCoverImage());
        mdEssay1.setSort(mdEssay.getSort());
        mdEssay1.setTextId(mdEssay2.getTextId());
        mdEssay1.setStatus(mdEssay.getStatus());
        mdEssay1.setId(mdEssay.getId());
        mdEssay1.setClickNum(mdEssay.getClickNum());

        return mdEssayMapper.updateMdEssay(mdEssay1);
    }

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的文章ID
     * @return 结果
     */
    @Override
    public int deleteMdEssayByIds(Integer[] ids) {
        int i = 0;
        for (Integer id : ids) {
            MdEssayVo mdEssayVO = mdEssayMapper.selectMdEssayById(id);
            Test01 test01 = new Test01();
            test01.setText(mdEssayVO.getText());
            Test01 text = test01Mapper.getText(test01);
            i = test01Mapper.delById(text.getId());
            if (i > 0) {
                i = mdEssayMapper.deleteMdEssayByIds(ids);
            }
        }
        return i;
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
