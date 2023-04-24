package com.cms.system.controller;

import com.cms.common.core.web.controller.BaseController;
import com.cms.common.core.web.domain.AjaxResult;
import com.cms.system.api.domain.SysDept;
import com.cms.system.domain.md.MdPaper;
import com.cms.system.service.MdQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门信息
 *
 * @author mdcms  官方网站：www.mdcms.vip
 */
@RestController
@RequestMapping("/que")
public class MDQuestionController extends BaseController {
    @Autowired
    private MdQuestionService questionService;

    /**
     * 获取问卷列表
     */
    @GetMapping("/paper")
    public AjaxResult list(String id) {
        MdPaper paper = questionService.getPaper(id);

        return AjaxResult.success(paper);
    }

}
