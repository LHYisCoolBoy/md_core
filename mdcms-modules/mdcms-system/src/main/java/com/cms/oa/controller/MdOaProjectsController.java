package com.cms.oa.controller;

import com.cms.common.core.utils.poi.ExcelUtil;
import com.cms.common.core.web.controller.BaseController;
import com.cms.common.core.web.domain.AjaxResult;
import com.cms.common.core.web.page.TableDataInfo;
import com.cms.common.log.annotation.Log;
import com.cms.common.log.enums.BusinessType;
import com.cms.common.security.annotation.PreAuthorize;
import com.cms.oa.domain.MdOaProjects;
import com.cms.oa.service.IMdOaProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 项目Controller
 *
 * @author lhy
 * @date 2023-05-17
 */
@RestController
@RequestMapping("/projects")
public class MdOaProjectsController extends BaseController {
    @Autowired
    private IMdOaProjectsService mdOaProjectsService;

    /**
     * 查询项目列表
     */
    @PreAuthorize(hasPermi = "system:projects:list")
    @GetMapping("/list")
    public TableDataInfo list(MdOaProjects mdOaProjects) {
        startPage();
        List<MdOaProjects> list = mdOaProjectsService.selectMdOaProjectsList(mdOaProjects);
        return getDataTable(list);
    }

    /**
     * 导出项目列表
     */
    @PreAuthorize(hasPermi = "system:projects:export")
    @Log(title = "项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdOaProjects mdOaProjects) throws IOException {
        List<MdOaProjects> list = mdOaProjectsService.selectMdOaProjectsList(mdOaProjects);
        ExcelUtil<MdOaProjects> util = new ExcelUtil<MdOaProjects>(MdOaProjects.class);
        util.exportExcel(response, list, "projects");
    }

    /**
     * 获取项目详细信息
     */
    @PreAuthorize(hasPermi = "system:projects:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(mdOaProjectsService.selectMdOaProjectsById(id));
    }

    /**
     * 新增项目
     */
    @PreAuthorize(hasPermi = "system:projects:add")
    @Log(title = "项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdOaProjects mdOaProjects) {
        return toAjax(mdOaProjectsService.insertMdOaProjects(mdOaProjects));
    }

    /**
     * 修改项目
     */
    @PreAuthorize(hasPermi = "system:projects:edit")
    @Log(title = "项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdOaProjects mdOaProjects) {
        return toAjax(mdOaProjectsService.updateMdOaProjects(mdOaProjects));
    }

    /**
     * 删除项目
     */
    @PreAuthorize(hasPermi = "system:projects:remove")
    @Log(title = "项目", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(mdOaProjectsService.deleteMdOaProjectsByIds(ids));
    }

    /**
     * 根据用户 ID 查询协同人是否包含自己，展示在消息部分
     *
     * @param userId
     * @return
     */
    @GetMapping("/selectByCollaboratorId")
    public AjaxResult selectByCollaboratorId(@RequestParam("userId") Long userId) {
        return AjaxResult.success(mdOaProjectsService.selectByCollaboratorId(userId));
    }
}
