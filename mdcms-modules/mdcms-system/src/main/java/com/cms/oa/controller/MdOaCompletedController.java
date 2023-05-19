package com.cms.oa.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
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
import com.cms.oa.domain.MdOaCompleted;
import com.cms.oa.service.IMdOaCompletedService;
import com.cms.common.core.web.controller.BaseController;
import com.cms.common.core.web.domain.AjaxResult;
import com.cms.common.core.utils.poi.ExcelUtil;
import com.cms.common.core.web.page.TableDataInfo;

/**
 * 已办Controller
 *
 * @author lhy
 * @date 2023-05-17
 */
@RestController
@RequestMapping("/completed")
public class MdOaCompletedController extends BaseController
{
    @Autowired
    private IMdOaCompletedService mdOaCompletedService;

    /**
     * 查询已办列表
     */
    @PreAuthorize(hasPermi = "system:completed:list")
    @GetMapping("/list")
    public TableDataInfo list(MdOaCompleted mdOaCompleted)
    {
        startPage();
        List<MdOaCompleted> list = mdOaCompletedService.selectMdOaCompletedList(mdOaCompleted);
        return getDataTable(list);
    }

    /**
     * 导出已办列表
     */
    @PreAuthorize(hasPermi = "system:completed:export")
    @Log(title = "已办", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdOaCompleted mdOaCompleted) throws IOException
    {
        List<MdOaCompleted> list = mdOaCompletedService.selectMdOaCompletedList(mdOaCompleted);
        ExcelUtil<MdOaCompleted> util = new ExcelUtil<MdOaCompleted>(MdOaCompleted.class);
        util.exportExcel(response, list, "completed");
    }

    /**
     * 获取已办详细信息
     */
    @PreAuthorize(hasPermi = "system:completed:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mdOaCompletedService.selectMdOaCompletedById(id));
    }

    /**
     * 新增已办
     */
    @PreAuthorize(hasPermi = "system:completed:add")
    @Log(title = "已办", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdOaCompleted mdOaCompleted)
    {
        return toAjax(mdOaCompletedService.insertMdOaCompleted(mdOaCompleted));
    }

    /**
     * 修改已办
     */
    @PreAuthorize(hasPermi = "system:completed:edit")
    @Log(title = "已办", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdOaCompleted mdOaCompleted)
    {
        return toAjax(mdOaCompletedService.updateMdOaCompleted(mdOaCompleted));
    }

    /**
     * 删除已办
     */
    @PreAuthorize(hasPermi = "system:completed:remove")
    @Log(title = "已办", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mdOaCompletedService.deleteMdOaCompletedByIds(ids));
    }
}
