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
import com.cms.xh.domain.MdXhTopic;
import com.cms.xh.service.IMdXhTopicService;
import com.cms.common.core.web.controller.BaseController;
import com.cms.common.core.web.domain.AjaxResult;
import com.cms.common.core.utils.poi.ExcelUtil;
import com.cms.common.core.web.page.TableDataInfo;

/**
 * 题目Controller
 *
 * @author lhy
 * @date 2023-05-09
 */
@RestController
@RequestMapping("/topic")
public class MdXhTopicController extends BaseController
{
    @Autowired
    private IMdXhTopicService mdXhTopicService;

    /**
     * 查询题目列表
     */
    @PreAuthorize(hasPermi = "system:topic:list")
    @GetMapping("/list")
    public TableDataInfo list(MdXhTopic mdXhTopic)
    {
        startPage();
        List<MdXhTopic> list = mdXhTopicService.selectMdXhTopicList(mdXhTopic);
        return getDataTable(list);
    }

    /**
     * 导出题目列表
     */
    @PreAuthorize(hasPermi = "system:topic:export")
    @Log(title = "题目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdXhTopic mdXhTopic) throws IOException
    {
        List<MdXhTopic> list = mdXhTopicService.selectMdXhTopicList(mdXhTopic);
        ExcelUtil<MdXhTopic> util = new ExcelUtil<MdXhTopic>(MdXhTopic.class);
        util.exportExcel(response, list, "topic");
    }

    /**
     * 获取题目详细信息
     */
    @PreAuthorize(hasPermi = "system:topic:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(mdXhTopicService.selectMdXhTopicById(id));
    }

    /**
     * 新增题目
     */
    @PreAuthorize(hasPermi = "system:topic:add")
    @Log(title = "题目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdXhTopic mdXhTopic)
    {
        return toAjax(mdXhTopicService.insertMdXhTopic(mdXhTopic));
    }

    /**
     * 修改题目
     */
    @PreAuthorize(hasPermi = "system:topic:edit")
    @Log(title = "题目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdXhTopic mdXhTopic)
    {
        return toAjax(mdXhTopicService.updateMdXhTopic(mdXhTopic));
    }

    /**
     * 删除题目
     */
    @PreAuthorize(hasPermi = "system:topic:remove")
    @Log(title = "题目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mdXhTopicService.deleteMdXhTopicByIds(ids));
    }
}
