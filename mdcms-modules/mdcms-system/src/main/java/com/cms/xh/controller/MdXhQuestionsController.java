package com.cms.xh.controller;

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
import com.cms.xh.domain.MdXhQuestions;
import com.cms.xh.service.IMdXhQuestionsService;
import com.cms.common.core.web.controller.BaseController;
import com.cms.common.core.web.domain.AjaxResult;
import com.cms.common.core.utils.poi.ExcelUtil;
import com.cms.common.core.web.page.TableDataInfo;

/**
 * 问卷答题Controller
 *
 * @author lhy
 * @date 2023-05-05
 */
@RestController
@RequestMapping("/questions")
public class MdXhQuestionsController extends BaseController
{
    @Autowired
    private IMdXhQuestionsService mdXhQuestionsService;

    /**
     * 查询问卷答题列表
     */
    @PreAuthorize(hasPermi = "system:questions:list")
    @GetMapping("/list")
    public TableDataInfo list(MdXhQuestions mdXhQuestions)
    {
        startPage();
        List<MdXhQuestions> list = mdXhQuestionsService.selectMdXhQuestionsList(mdXhQuestions);
        return getDataTable(list);
    }

    /**
     * 导出问卷答题列表
     */
    @PreAuthorize(hasPermi = "system:questions:export")
    @Log(title = "问卷答题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdXhQuestions mdXhQuestions) throws IOException
    {
        List<MdXhQuestions> list = mdXhQuestionsService.selectMdXhQuestionsList(mdXhQuestions);
        ExcelUtil<MdXhQuestions> util = new ExcelUtil<MdXhQuestions>(MdXhQuestions.class);
        util.exportExcel(response, list, "questions");
    }

    /**
     * 获取问卷答题详细信息
     */
    @PreAuthorize(hasPermi = "system:questions:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mdXhQuestionsService.selectMdXhQuestionsById(id));
    }

    /**
     * 新增问卷答题
     */
    @PreAuthorize(hasPermi = "system:questions:add")
    @Log(title = "问卷答题", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdXhQuestions mdXhQuestions)
    {
        return toAjax(mdXhQuestionsService.insertMdXhQuestions(mdXhQuestions));
    }

    /**
     * 修改问卷答题
     */
    @PreAuthorize(hasPermi = "system:questions:edit")
    @Log(title = "问卷答题", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdXhQuestions mdXhQuestions)
    {
        return toAjax(mdXhQuestionsService.updateMdXhQuestions(mdXhQuestions));
    }

    /**
     * 删除问卷答题
     */
    @PreAuthorize(hasPermi = "system:questions:remove")
    @Log(title = "问卷答题", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mdXhQuestionsService.deleteMdXhQuestionsByIds(ids));
    }
}
