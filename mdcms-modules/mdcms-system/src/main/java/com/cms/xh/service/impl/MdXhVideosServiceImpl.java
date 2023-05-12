package com.cms.xh.service.impl;

import java.util.List;

import com.cms.common.core.exception.BaseException;
import com.cms.common.core.utils.DateUtils;
import com.cms.xh.domain.MdXhUsers;
import com.cms.xh.mapper.MdXhUsersMapper;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class MdXhVideosServiceImpl implements IMdXhVideosService {
    @Autowired
    private MdXhVideosMapper mdXhVideosMapper;

    @Autowired
    private MdXhUsersMapper mdXhUsersMapper;


    /**
     * 查询视频信息
     *
     * @param id 视频信息ID
     * @return 视频信息
     */
    @Override
    public MdXhVideos selectMdXhVideosById(Long id) {
        return mdXhVideosMapper.selectMdXhVideosById(id);
    }

    /**
     * 查询视频信息列表
     *
     * @param mdXhVideos 视频信息
     * @return 视频信息
     */
    @Override
    public List<MdXhVideos> selectMdXhVideosList(MdXhVideos mdXhVideos) {
        return mdXhVideosMapper.selectMdXhVideosList(mdXhVideos);
    }

    /**
     * 新增视频信息
     *
     * @param mdXhVideos 视频信息
     * @return 结果
     */
    @Override
    public int insertMdXhVideos(MdXhVideos mdXhVideos) {
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
    public int updateMdXhVideos(MdXhVideos mdXhVideos) {
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
    public int deleteMdXhVideosByIds(Long[] ids) {
        return mdXhVideosMapper.deleteMdXhVideosByIds(ids);
    }

    /**
     * 删除视频信息信息
     *
     * @param id 视频信息ID
     * @return 结果
     */
    @Override
    public int deleteMdXhVideosById(Long id) {
        return mdXhVideosMapper.deleteMdXhVideosById(id);
    }

    /**
     * 根据用户 ID 累计用户观看次数
     *
     * @param userId 用户 ID
     * @return
     */
    @Override
    public int updateUserWatchCount(Long userId) {
        if (userId == null) {
            log.info("updateUserWatchCount:id is {}", userId);
            throw new BaseException("参数不能为空");
        }
        isWatchVideo(userId);
        return mdXhUsersMapper.updateUserWatchCount(userId);
    }

    /**
     * 根据用户 ID 累计用户观看时间
     *
     * @param userId    用户 ID
     * @param watchTime 用户观看时间
     * @return
     */
    @Override
    public int updateUserWatchTime(Long userId, Long watchTime) {
        if (userId == null || watchTime == null) {
            log.info("updateUserWatchCount:id is {},watchTime is {}", userId, watchTime);
            throw new BaseException("参数不能为空");
        }
        return mdXhUsersMapper.updateUserWatchTime(userId, watchTime);
    }

    /**
     * 判断用户是否能继续观看视频
     *
     * @param userId 用户 ID
     */
    private void isWatchVideo(Long userId) {
        MdXhUsers mdXhUsers = mdXhUsersMapper.selectMdXhUsersById(userId);
        if (mdXhUsers == null) {
            log.info("isWatchVideo:mdXhUsers is {}", mdXhUsers);
            throw new BaseException("查不到该用户");
        }
        if (mdXhUsers.getWatchCount() >= 3 || mdXhUsers.getWatchTime() >= 11400) {
            log.info("isWatchVideo:mdXhUsers.getWatchCount() is {},mdXhUsers.getWatchTime() is {}", mdXhUsers.getWatchCount(), mdXhUsers.getWatchTime());
            throw new BaseException("不能观看视频了，可以开始答题了");
        }
    }

}
