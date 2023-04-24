package com.cms.gzh.mapper;

import java.util.List;
import com.cms.gzh.domain.MdConfig;

/**
 * 推荐配置Mapper接口
 * 
 * @author lhy
 * @date 2023-04-21
 */
public interface MdConfigMapper 
{
    /**
     * 查询推荐配置
     * 
     * @param id 推荐配置ID
     * @return 推荐配置
     */
    public MdConfig selectMdConfigById(Long id);

    /**
     * 查询推荐配置列表
     * 
     * @param mdConfig 推荐配置
     * @return 推荐配置集合
     */
    public List<MdConfig> selectMdConfigList(MdConfig mdConfig);

    /**
     * 新增推荐配置
     * 
     * @param mdConfig 推荐配置
     * @return 结果
     */
    public int insertMdConfig(MdConfig mdConfig);

    /**
     * 修改推荐配置
     * 
     * @param mdConfig 推荐配置
     * @return 结果
     */
    public int updateMdConfig(MdConfig mdConfig);

    /**
     * 删除推荐配置
     * 
     * @param id 推荐配置ID
     * @return 结果
     */
    public int deleteMdConfigById(Long id);

    /**
     * 批量删除推荐配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMdConfigByIds(Long[] ids);
}
