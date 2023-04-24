package com.cms.gzh.service.impl;

import java.util.List;

import com.cms.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cms.gzh.mapper.MdConfigMapper;
import com.cms.gzh.domain.MdConfig;
import com.cms.gzh.service.IMdConfigService;

/**
 * 推荐配置Service业务层处理
 *
 * @author lhy
 * @date 2023-04-21
 */
@Service
public class MdConfigServiceImpl implements IMdConfigService {
    @Autowired
    private MdConfigMapper mdConfigMapper;

    /**
     * 查询推荐配置
     *
     * @param id 推荐配置ID
     * @return 推荐配置
     */
    @Override
    public MdConfig selectMdConfigById(Long id) {
        return mdConfigMapper.selectMdConfigById(id);
    }

    /**
     * 查询推荐配置列表
     *
     * @param mdConfig 推荐配置
     * @return 推荐配置
     */
    @Override
    public List<MdConfig> selectMdConfigList(MdConfig mdConfig) {
        return mdConfigMapper.selectMdConfigList(mdConfig);
    }

    /**
     * 新增推荐配置
     *
     * @param mdConfig 推荐配置
     * @return 结果
     */
    @Override
    public int insertMdConfig(MdConfig mdConfig) {
        mdConfig.setCreateTime(DateUtils.getNowDate());
        return mdConfigMapper.insertMdConfig(mdConfig);
    }

    /**
     * 修改推荐配置
     *
     * @param mdConfig 推荐配置
     * @return 结果
     */
    @Override
    public int updateMdConfig(MdConfig mdConfig) {
        mdConfig.setUpdateTime(DateUtils.getNowDate());
        return mdConfigMapper.updateMdConfig(mdConfig);
    }

    /**
     * 批量删除推荐配置
     *
     * @param ids 需要删除的推荐配置ID
     * @return 结果
     */
    @Override
    public int deleteMdConfigByIds(Long[] ids) {
        return mdConfigMapper.deleteMdConfigByIds(ids);
    }

    /**
     * 删除推荐配置信息
     *
     * @param id 推荐配置ID
     * @return 结果
     */
    @Override
    public int deleteMdConfigById(Long id) {
        return mdConfigMapper.deleteMdConfigById(id);
    }
}
