package com.cms.gzh.controller;

import java.util.List;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.cms.gzh.domain.MdEssayDTO;
import com.cms.gzh.domain.MdEssayVO;
import com.cms.gzh.domain.Test01;
import com.cms.gzh.mapper.Test01Mapper;
import com.cms.system.api.domain.IdNameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        List<MdEssayVO> list = mdEssayService.selectMdEssayList(mdEssay);
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
        List<MdEssayVO> list = mdEssayService.selectMdEssayList(mdEssay);
        ExcelUtil<MdEssayVO> util = new ExcelUtil<MdEssayVO>(MdEssayVO.class);
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
    public AjaxResult add(@RequestBody MdEssayDTO mdEssay) {
        return toAjax(mdEssayService.insertMdEssay(mdEssay));
    }

    /**
     * 修改文章
     */
    @PreAuthorize(hasPermi = "system:essay:edit")
    @Log(title = "文章", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdEssayDTO mdEssay) {
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
