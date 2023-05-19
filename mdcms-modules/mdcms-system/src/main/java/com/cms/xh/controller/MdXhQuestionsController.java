package com.cms.xh.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.cms.common.core.exception.BaseException;
import com.cms.xh.domain.vo.MdXhQuestionsVO;
import com.cms.xh.service.IMdXhVideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
 * @date 2023-05-08
 */
@RestController
@RequestMapping("/questions")
public class MdXhQuestionsController extends BaseController {
    @Autowired
    private IMdXhQuestionsService mdXhQuestionsService;

    @Autowired
    private IMdXhQuestionsService iMdXhQuestionsService;

    /**
     * 查询问卷答题列表
     */
    @PreAuthorize(hasPermi = "system:questions:list")
    @GetMapping("/list")
    public TableDataInfo list(MdXhQuestionsVO mdXhQuestions) {
        startPage();
        List<MdXhQuestionsVO> list = mdXhQuestionsService.selectMdXhQuestionsList(mdXhQuestions);
        return getDataTable(list);
    }

    /**
     * 导出问卷答题列表
     */
    @PreAuthorize(hasPermi = "system:questions:export")
    @Log(title = "问卷答题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdXhQuestionsVO mdXhQuestions) throws IOException {
        List<MdXhQuestionsVO> list = mdXhQuestionsService.selectMdXhQuestionsList(mdXhQuestions);
        ExcelUtil<MdXhQuestionsVO> util = new ExcelUtil<MdXhQuestionsVO>(MdXhQuestionsVO.class);
        util.exportExcel(response, list, "questions");
    }

    /**
     * 获取问卷答题详细信息
     */
    @PreAuthorize(hasPermi = "system:questions:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(mdXhQuestionsService.selectMdXhQuestionsById(id));
    }

    /**
     * 新增问卷答题
     */
    @PreAuthorize(hasPermi = "system:questions:add")
    @Log(title = "问卷答题", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdXhQuestions mdXhQuestions) {
        return toAjax(mdXhQuestionsService.insertMdXhQuestions(mdXhQuestions));
    }

    /**
     * 修改问卷答题
     */
    @PreAuthorize(hasPermi = "system:questions:edit")
    @Log(title = "问卷答题", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdXhQuestions mdXhQuestions) {
        return toAjax(mdXhQuestionsService.updateMdXhQuestions(mdXhQuestions));
    }

    /**
     * 删除问卷答题
     */
    @PreAuthorize(hasPermi = "system:questions:remove")
    @Log(title = "问卷答题", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(mdXhQuestionsService.deleteMdXhQuestionsByIds(ids));
    }

    /**
     * 判断用户是否可以开始答题
     *
     * @param userId 用户 ID
     * @return
     */
    @GetMapping("/canAnswerTheQuestion")
    public AjaxResult canAnswerTheQuestion(@RequestParam("userId") Long userId) {
        iMdXhQuestionsService.isWatchVideo(userId);
        return AjaxResult.success();
    }

    /**
     * 用户提交题目
     *
     * @param mdQuestion
     * @return
     */
    @Log(title = "问卷答题", businessType = BusinessType.INSERT)
    @PostMapping("/addUserQuestions")
    public AjaxResult addUserQuestions(@RequestBody List<MdXhQuestions> mdQuestion) {
        return AjaxResult.success(mdXhQuestionsService.addUserQuestions(mdQuestion));
    }
}
