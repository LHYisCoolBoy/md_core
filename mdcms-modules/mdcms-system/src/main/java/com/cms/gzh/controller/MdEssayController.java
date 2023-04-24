package com.cms.gzh.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.cms.system.api.domain.IdNameVo;
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
import com.cms.gzh.domain.MdEssay;
import com.cms.gzh.service.IMdEssayService;
import com.cms.common.core.web.controller.BaseController;
import com.cms.common.core.web.domain.AjaxResult;
import com.cms.common.core.utils.poi.ExcelUtil;
import com.cms.common.core.web.page.TableDataInfo;

/**
 * 文章Controller
 *
 * @author lhy
 * @date 2023-04-19
 */
@RestController
@RequestMapping("/essay")
public class MdEssayController extends BaseController {
    @Autowired
    private IMdEssayService mdEssayService;

    /**
     * 查询文章列表
     */
    @PreAuthorize(hasPermi = "system:essay:list")
    @GetMapping("/list")
    public TableDataInfo list(MdEssay mdEssay) {
        startPage();
        List<MdEssay> list = mdEssayService.selectMdEssayList(mdEssay);
        return getDataTable(list);
    }

    /**
     * 查询文章列表
     */
    @GetMapping("/nameList")
    public AjaxResult nameList() {
        List<IdNameVo> list = mdEssayService.nameList();
        return AjaxResult.success(list);
    }

    /**
     * 导出文章列表
     */
    @PreAuthorize(hasPermi = "system:essay:export")
    @Log(title = "文章", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdEssay mdEssay) throws IOException {
        List<MdEssay> list = mdEssayService.selectMdEssayList(mdEssay);
        ExcelUtil<MdEssay> util = new ExcelUtil<MdEssay>(MdEssay.class);
        util.exportExcel(response, list, "essay");
    }

    /**
     * 获取文章详细信息
     */
    @PreAuthorize(hasPermi = "system:essay:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id) {
        return AjaxResult.success(mdEssayService.selectMdEssayById(id));
    }

    /**
     * 新增文章
     */
    @PreAuthorize(hasPermi = "system:essay:add")
    @Log(title = "文章", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdEssay mdEssay) {
        return toAjax(mdEssayService.insertMdEssay(mdEssay));
    }

    /**
     * 修改文章
     */
    @PreAuthorize(hasPermi = "system:essay:edit")
    @Log(title = "文章", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdEssay mdEssay) {
        return toAjax(mdEssayService.updateMdEssay(mdEssay));
    }

    /**
     * 删除文章
     */
    @PreAuthorize(hasPermi = "system:essay:remove")
    @Log(title = "文章", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids) {
        return toAjax(mdEssayService.deleteMdEssayByIds(ids));
    }
}
