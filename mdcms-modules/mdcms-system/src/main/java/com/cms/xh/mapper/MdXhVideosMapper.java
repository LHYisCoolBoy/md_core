package com.cms.xh.mapper;

import java.util.List;

import com.cms.xh.domain.MdXhVideos;
import org.springframework.stereotype.Repository;

/**
 * 视频信息Mapper接口
 *
 * @author lhy
 * @date 2023-05-08
 */
public interface MdXhVideosMapper {
    /**
     * 查询视频信息
     *
     * @param id 视频信息ID
     * @return 视频信息
     */
    public MdXhVideos selectMdXhVideosById(Long id);

    /**
     * 查询视频信息列表
     *
     * @param mdXhVideos 视频信息
     * @return 视频信息集合
     */
    public List<MdXhVideos> selectMdXhVideosList(MdXhVideos mdXhVideos);

    /**
     * 新增视频信息
     *
     * @param mdXhVideos 视频信息
     * @return 结果
     */
    public int insertMdXhVideos(MdXhVideos mdXhVideos);

    /**
     * 修改视频信息
     *
     * @param mdXhVideos 视频信息
     * @return 结果
     */
    public int updateMdXhVideos(MdXhVideos mdXhVideos);

    /**
     * 删除视频信息
     *
     * @param id 视频信息ID
     * @return 结果
     */
    public int deleteMdXhVideosById(Long id);

    /**
     * 批量删除视频信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMdXhVideosByIds(Long[] ids);
}
