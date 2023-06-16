package com.cms.gzh.service;

import java.util.List;
import com.cms.gzh.domain.MdEssay;
import com.cms.gzh.domain.dto.MdEssayDto;
import com.cms.gzh.domain.vo.MdEssayVo;
import com.cms.system.api.domain.IdNameVo;

/**
 * 文章Service接口
 *
 * @author lhy
 * @date 2023-04-19
 */
public interface IMdEssayService
{
    /**
     * 查询文章
     *
     * @param id 文章ID
     * @return 文章
     */
    public MdEssayVo selectMdEssayById(Integer id);

    /**
     * 查询文章列表
     *
     * @param mdEssay 文章
     * @return 文章集合
     */
    public List<MdEssayVo> selectMdEssayList(MdEssay mdEssay);

    /**
     * 新增文章
     *
     * @param mdEssay 文章
     * @return 结果
     */
    public int insertMdEssay(MdEssayDto mdEssay);

    /**
     * 修改文章
     *
     * @param mdEssay 文章
     * @return 结果
     */
    public int updateMdEssay(MdEssayDto mdEssay);

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的文章ID
     * @return 结果
     */
    public int deleteMdEssayByIds(Integer[] ids);

    /**
     * 删除文章信息
     *
     * @param id 文章ID
     * @return 结果
     */
    public int deleteMdEssayById(Integer id);

    List<IdNameVo> nameList();
}
