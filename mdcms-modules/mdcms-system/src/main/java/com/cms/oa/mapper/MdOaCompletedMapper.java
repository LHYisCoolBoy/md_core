package com.cms.oa.mapper;

import java.util.List;

import com.cms.oa.domain.MdOaCompleted;
import org.springframework.stereotype.Repository;

/**
 * 已办Mapper接口
 *
 * @author lhy
 * @date 2023-05-17
 */
@Repository
public interface MdOaCompletedMapper {
    /**
     * 查询已办
     *
     * @param id 已办ID
     * @return 已办
     */
    public MdOaCompleted selectMdOaCompletedById(Long id);

    /**
     * 查询已办列表
     *
     * @param mdOaCompleted 已办
     * @return 已办集合
     */
    public List<MdOaCompleted> selectMdOaCompletedList(MdOaCompleted mdOaCompleted);


    /**
     * 根据项目 ID 查询是否有该记录
     *
     * @param mdOaCompleted
     * @return
     */
    MdOaCompleted selectMdOaCompleted(MdOaCompleted mdOaCompleted);

    /**
     * 新增已办
     *
     * @param mdOaCompleted 已办
     * @return 结果
     */
    public int insertMdOaCompleted(MdOaCompleted mdOaCompleted);

    /**
     * 修改已办
     *
     * @param mdOaCompleted 已办
     * @return 结果
     */
    public int updateMdOaCompleted(MdOaCompleted mdOaCompleted);

    /**
     * 删除已办
     *
     * @param id 已办ID
     * @return 结果
     */
    public int deleteMdOaCompletedById(Long id);

    /**
     * 批量删除已办
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMdOaCompletedByIds(Long[] ids);


}
