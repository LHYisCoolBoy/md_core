package com.cms.ydisk.service.impl;

import java.util.List;

import com.cms.system.mapper.SysDeptMapper;
import com.cms.system.mapper.SysUserMapper;
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
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysDeptMapper deptMapper;

    /**
     * 查询捷电网盘
     *
     * @param id 捷电网盘ID
     * @return 捷电网盘
     */
    @Override
    public MdYdiskFile selectMdYdiskFileById(Long id) {
        MdYdiskFile mdYdiskFile = mdYdiskFileMapper.selectMdYdiskFileById(id);
        try{
            mdYdiskFile.setDeptId(deptMapper.selectDeptById(Long.valueOf(mdYdiskFile.getDeptId())).getDeptName());
            mdYdiskFile.setUserId(userMapper.selectUserById(Long.valueOf(mdYdiskFile.getUserId())).getNickName());
        }catch (Exception e){
            mdYdiskFile.setDeptId("未分配部门");
            mdYdiskFile.setUserId("未知上传者");
        }
        return mdYdiskFile;
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
        mdYdiskFile.setDeptId(mdYdiskFileMapper.getDeptIdByUserId(Long.valueOf(mdYdiskFile.getUserId())));
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
        mdYdiskFile.setDeptId(mdYdiskFileMapper.getDeptIdByUserId(Long.valueOf(mdYdiskFile.getUserId())));
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
