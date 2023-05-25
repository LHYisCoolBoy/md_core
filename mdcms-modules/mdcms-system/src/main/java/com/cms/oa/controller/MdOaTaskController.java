package com.cms.oa.controller;

import com.cms.common.core.utils.poi.ExcelUtil;
import com.cms.common.core.web.controller.BaseController;
import com.cms.common.core.web.domain.AjaxResult;
import com.cms.common.core.web.page.TableDataInfo;
import com.cms.common.log.annotation.Log;
import com.cms.common.log.enums.BusinessType;
import com.cms.common.security.annotation.PreAuthorize;
import com.cms.oa.domain.MdOaProjects;
import com.cms.oa.domain.vo.MdOaProjectsVO;
import com.cms.oa.service.IMdOaProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 我的待办信息
 */
@RestController
@RequestMapping("/task")
public class MdOaTaskController extends BaseController {

    @Autowired
    private IMdOaProjectsService mdOaProjectsService;

    /**
     * 查询项目列表
     */
    @PreAuthorize(hasPermi = "system:task:list")
    @GetMapping("/list")
    public TableDataInfo list(MdOaProjects mdOaProjects) {
        startPage();
        List<MdOaProjectsVO> list = mdOaProjectsService.selectAllByUserIdAndIsComplete(mdOaProjects);
        return getDataTable(list);
    }

    /**
     * 根据用户 ID 和是否已支付查询所有信息
     *
     * @param mdOaProjects
     * @return
     */
    @GetMapping("/selectAllByCollaboratorId")

    public TableDataInfo selectAllByCollaboratorId(MdOaProjects mdOaProjects) {
        startPage();
        List<MdOaProjectsVO> list = mdOaProjectsService.selectAllByCollaboratorId(mdOaProjects);
        return getDataTable(list);
    }

    /**
     * 根据项目 ID 更新该项目的是否已完成字段为已完成
     *
     * @param mdOaProjects
     * @return
     */
    @Log(title = "项目", businessType = BusinessType.UPDATE)
    @PostMapping("/updateIsCompleteById")
    public AjaxResult updateIsCompleteById(@RequestBody MdOaProjects mdOaProjects) {
        return toAjax(mdOaProjectsService.updateIsCompleteById(mdOaProjects));
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
}
