package com.cms.ydisk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cms.ydisk.mapper.MdYdiskFileMapper;
import com.cms.ydisk.domain.MdYdiskFile;
import com.cms.ydisk.service.IMdYdiskFileService;

/**
 * 捷电网盘Service业务层处理
 *
 * @author LK
 * @date 2023-05-19
 */
@Service
public class MdYdiskFileServiceImpl implements IMdYdiskFileService {
    @Autowired
    private MdYdiskFileMapper mdYdiskFileMapper;

    /**
     * 查询捷电网盘
     *
     * @param id 捷电网盘ID
     * @return 捷电网盘
     */
    @Override
    public MdYdiskFile selectMdYdiskFileById(Long id) {
        return mdYdiskFileMapper.selectMdYdiskFileById(id);
    }

    /**
     * 查询捷电网盘列表
     *
     * @param mdYdiskFile 捷电网盘
     * @return 捷电网盘
     */
    @Override
    public List<MdYdiskFile> selectMdYdiskFileList(MdYdiskFile mdYdiskFile) {
        return mdYdiskFileMapper.selectMdYdiskFileList(mdYdiskFile);
    }

    /**
     * 新增捷电网盘
     *
     * @param mdYdiskFile 捷电网盘
     * @return 结果
     */
    @Override
    public int insertMdYdiskFile(MdYdiskFile mdYdiskFile) {
        mdYdiskFile.setDeptId(mdYdiskFileMapper.getDeptIdByUserId(mdYdiskFile.getUserId()));
        return mdYdiskFileMapper.insertMdYdiskFile(mdYdiskFile);
    }

    /**
     * 修改捷电网盘
     *
     * @param mdYdiskFile 捷电网盘
     * @return 结果
     */
    @Override
    public int updateMdYdiskFile(MdYdiskFile mdYdiskFile) {
        mdYdiskFile.setDeptId(mdYdiskFileMapper.getDeptIdByUserId(mdYdiskFile.getUserId()));
        return mdYdiskFileMapper.updateMdYdiskFile(mdYdiskFile);
    }

    /**
     * 批量删除捷电网盘
     *
     * @param ids 需要删除的捷电网盘ID
     * @return 结果
     */
    @Override
    public int deleteMdYdiskFileByIds(Long[] ids) {
        return mdYdiskFileMapper.deleteMdYdiskFileByIds(ids);
    }

    /**
     * 删除捷电网盘信息
     *
     * @param id 捷电网盘ID
     * @return 结果
     */
    @Override
    public int deleteMdYdiskFileById(Long id) {
        return mdYdiskFileMapper.deleteMdYdiskFileById(id);
    }
}
