package com.cms.ydisk.service;

import java.util.List;
import com.cms.ydisk.domain.MdYdiskFile;

/**
 * 捷电网盘Service接口
 *
 * @author LK
 * @date 2023-05-19
 */
public interface IMdYdiskFileService
{
    /**
     * 查询捷电网盘
     *
     * @param id 捷电网盘ID
     * @return 捷电网盘
     */
    public MdYdiskFile selectMdYdiskFileById(Long id);

    /**
     * 查询捷电网盘列表
     *
     * @param mdYdiskFile 捷电网盘
     * @return 捷电网盘集合
     */
    public List<MdYdiskFile> selectMdYdiskFileList(MdYdiskFile mdYdiskFile);

    /**
     * 新增捷电网盘
     *
     * @param mdYdiskFile 捷电网盘
     * @return 结果
     */
    public int insertMdYdiskFile(MdYdiskFile mdYdiskFile);

    /**
     * 修改捷电网盘
     *
     * @param mdYdiskFile 捷电网盘
     * @return 结果
     */
    public int updateMdYdiskFile(MdYdiskFile mdYdiskFile);

    /**
     * 批量删除捷电网盘
     *
     * @param ids 需要删除的捷电网盘ID
     * @return 结果
     */
    public int deleteMdYdiskFileByIds(Long[] ids);

    /**
     * 删除捷电网盘信息
     *
     * @param id 捷电网盘ID
     * @return 结果
     */
    public int deleteMdYdiskFileById(Long id);
}
