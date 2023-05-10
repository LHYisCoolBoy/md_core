package com.cms.xh.service.impl;

import java.util.List;
import com.cms.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cms.xh.mapper.MdXhVideosMapper;
import com.cms.xh.domain.MdXhVideos;
import com.cms.xh.service.IMdXhVideosService;

/**
 * 视频信息Service业务层处理
 *
 * @author lhy
 * @date 2023-05-08
 */
@Service
public class MdXhVideosServiceImpl implements IMdXhVideosService
{
    @Autowired
    private MdXhVideosMapper mdXhVideosMapper;

    /**
     * 查询视频信息
     *
     * @param id 视频信息ID
     * @return 视频信息
     */
    @Override
    public MdXhVideos selectMdXhVideosById(Long id)
    {
        return mdXhVideosMapper.selectMdXhVideosById(id);
    }

    /**
     * 查询视频信息列表
     *
     * @param mdXhVideos 视频信息
     * @return 视频信息
     */
    @Override
    public List<MdXhVideos> selectMdXhVideosList(MdXhVideos mdXhVideos)
    {
        return mdXhVideosMapper.selectMdXhVideosList(mdXhVideos);
    }

    /**
     * 新增视频信息
     *
     * @param mdXhVideos 视频信息
     * @return 结果
     */
    @Override
    public int insertMdXhVideos(MdXhVideos mdXhVideos)
    {
        mdXhVideos.setCreateTime(DateUtils.getNowDate());
        return mdXhVideosMapper.insertMdXhVideos(mdXhVideos);
    }

    /**
     * 修改视频信息
     *
     * @param mdXhVideos 视频信息
     * @return 结果
     */
    @Override
    public int updateMdXhVideos(MdXhVideos mdXhVideos)
    {
        mdXhVideos.setUpdateTime(DateUtils.getNowDate());
        return mdXhVideosMapper.updateMdXhVideos(mdXhVideos);
    }

    /**
     * 批量删除视频信息
     *
     * @param ids 需要删除的视频信息ID
     * @return 结果
     */
    @Override
    public int deleteMdXhVideosByIds(Long[] ids)
    {
        return mdXhVideosMapper.deleteMdXhVideosByIds(ids);
    }

    /**
     * 删除视频信息信息
     *
     * @param id 视频信息ID
     * @return 结果
     */
    @Override
    public int deleteMdXhVideosById(Long id)
    {
        return mdXhVideosMapper.deleteMdXhVideosById(id);
    }
}
