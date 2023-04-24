package com.cms.gzh.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.cms.gzh.service.SysGzhUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cms.common.log.annotation.Log;
import com.cms.common.log.enums.BusinessType;
import com.cms.common.security.annotation.PreAuthorize;
import com.cms.gzh.domain.SysGzhUser;
import com.cms.common.core.web.controller.BaseController;
import com.cms.common.core.web.domain.AjaxResult;
import com.cms.common.core.utils.poi.ExcelUtil;
import com.cms.common.core.web.page.TableDataInfo;

/**
 * 公众号用户名Controller
 *
 * @author lhy
 * @date 2023-04-10
 */
@RestController
@RequestMapping("/gzhuser")
public class SysGzhUserController extends BaseController
{
    @Autowired
    private SysGzhUserService sysUserService;

    /**
     * 查询公众号用户名列表
     */
    @PreAuthorize(hasPermi = "system:gzhuser:list")
    @GetMapping("/list")
    public TableDataInfo list(SysGzhUser sysUser)
    {
        startPage();
        List<SysGzhUser> list = sysUserService.selectSysUserList(sysUser);
        return getDataTable(list);
    }

    /**
     * 导出公众号用户名列表
     */
    @PreAuthorize(hasPermi = "system:gzhuser:export")
    @Log(title = "公众号用户名", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysGzhUser sysUser) throws IOException
    {
        List<SysGzhUser> list = sysUserService.selectSysUserList(sysUser);
        ExcelUtil<SysGzhUser> util = new ExcelUtil<SysGzhUser>(SysGzhUser.class);
        util.exportExcel(response, list, "gzhuser");
    }

    /**
     * 获取公众号用户名详细信息
     */
    @PreAuthorize(hasPermi = "system:gzhuser:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysUserService.selectSysUserById(id));
    }

    /**
     * 新增公众号用户名
     */
    @PreAuthorize(hasPermi = "system:gzhuser:add")
    @Log(title = "公众号用户名", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysGzhUser sysUser)
    {
        return toAjax(sysUserService.insertSysUser(sysUser));
    }

    /**
     * 修改公众号用户名
     */
    @PreAuthorize(hasPermi = "system:gzhuser:edit")
    @Log(title = "公众号用户名", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysGzhUser sysUser)
    {
        return toAjax(sysUserService.updateSysUser(sysUser));
    }

    /**
     * 删除公众号用户名
     */
    @PreAuthorize(hasPermi = "system:gzhuser:remove")
    @Log(title = "公众号用户名", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysUserService.deleteSysUserByIds(ids));
    }
}
