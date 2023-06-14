package com.cms.gzh.mapper;

import java.util.List;

import com.cms.gzh.domain.MdEssay;
import com.cms.gzh.domain.MdEssayDTO;
import com.cms.gzh.domain.MdEssayVO;
import com.cms.system.api.domain.IdNameVo;
import org.apache.ibatis.annotations.Param;

/**
 * 文章Mapper接口
 *
 * @author lhy
 * @date 2023-04-19
 */
public interface MdEssayMapper {
    /**
     * 查询文章
     *
     * @param id 文章ID
     * @return 文章
     */
    public MdEssayVO selectMdEssayById(Integer id);

    /**
     * 查询文章 根据 ID
     *
     * @param id 文章ID
     * @return 文章
     */
    public MdEssay selectMdEssayById01(Integer id);

    /**
     * 查询文章列表
     *
     * @param mdEssay 文章
     * @return 文章集合
     */
    public List<MdEssayVO> selectMdEssayList(MdEssay mdEssay);

    /**
     * 新增文章
     *
     * @param mdEssay 文章
     * @return 结果
     */
    public int insertMdEssay(MdEssay mdEssay);

    /**
     * 修改文章
     *
     * @param mdEssay 文章
     * @return 结果
     */
    public int updateMdEssay(MdEssay mdEssay);

    /**
     * 删除文章
     *
     * @param id 文章ID
     * @return 结果
     */
    public int deleteMdEssayById(Integer id);

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMdEssayByIds(Integer[] ids);

    List<IdNameVo> nameList();
}
