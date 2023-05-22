package com.cms.ydisk.controller;

import java.security.Security;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.cms.common.core.utils.SecurityUtils;
import com.cms.ydisk.domain.MdYdiskFile;
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
import com.cms.ydisk.service.IMdYdiskFileService;
import com.cms.common.core.web.controller.BaseController;
import com.cms.common.core.web.domain.AjaxResult;
import com.cms.common.core.utils.poi.ExcelUtil;
import com.cms.common.core.web.page.TableDataInfo;

/**
 * 捷电网盘Controller
 *
 * @author LK
 * @date 2023-05-19
 */
@RestController
@RequestMapping("/ydisk")
public class MdYdiskFileController extends BaseController {
    @Autowired
    private IMdYdiskFileService mdYdiskFileService;

    /**
     * 查询捷电网盘列表
     */
    @PreAuthorize(hasPermi = "system:ydisk:list")
    @GetMapping("/list")
    public TableDataInfo list(MdYdiskFile mdYdiskFile) {
        startPage();
        List<MdYdiskFile> list = mdYdiskFileService.selectMdYdiskFileList(mdYdiskFile);
        return getDataTable(list);
    }

    /**
     * 导出捷电网盘列表
     */
    @PreAuthorize(hasPermi = "system:ydisk:export")
    @Log(title = "捷电网盘", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdYdiskFile mdYdiskFile) throws IOException {
        List<MdYdiskFile> list = mdYdiskFileService.selectMdYdiskFileList(mdYdiskFile);
        ExcelUtil<MdYdiskFile> util = new ExcelUtil<MdYdiskFile>(MdYdiskFile.class);
        util.exportExcel(response, list, "ydisk");
    }

    /**
     * 获取捷电网盘详细信息
     */
    @PreAuthorize(hasPermi = "system:ydisk:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(mdYdiskFileService.selectMdYdiskFileById(id));
    }

    /**
     * 新增捷电网盘
     */
    @PreAuthorize(hasPermi = "system:ydisk:add")
    @Log(title = "捷电网盘", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdYdiskFile mdYdiskFile) {
        mdYdiskFile.setUserId(SecurityUtils.getUserId());
        return toAjax(mdYdiskFileService.insertMdYdiskFile(mdYdiskFile));
    }

    /**
     * 修改捷电网盘
     */
    @PreAuthorize(hasPermi = "system:ydisk:edit")
    @Log(title = "捷电网盘", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdYdiskFile mdYdiskFile) {
        mdYdiskFile.setUserId(SecurityUtils.getUserId());
        return toAjax(mdYdiskFileService.updateMdYdiskFile(mdYdiskFile));
    }

    /**
     * 删除捷电网盘
     */
    @PreAuthorize(hasPermi = "system:ydisk:remove")
    @Log(title = "捷电网盘", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(mdYdiskFileService.deleteMdYdiskFileByIds(ids));
    }
}
