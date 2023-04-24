package com.cms.gzh.controller;

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
import com.cms.gzh.domain.MdConfig;
import com.cms.gzh.service.IMdConfigService;
import com.cms.common.core.web.controller.BaseController;
import com.cms.common.core.web.domain.AjaxResult;
import com.cms.common.core.utils.poi.ExcelUtil;
import com.cms.common.core.web.page.TableDataInfo;

/**
 * 推荐配置Controller
 *
 * @author lhy
 * @date 2023-04-21
 */
@RestController
@RequestMapping("/mdconfig")
public class MdConfigController extends BaseController {
    @Autowired
    private IMdConfigService mdConfigService;

    /**
     * 查询推荐配置列表
     */
    @PreAuthorize(hasPermi = "system:mdconfig:list")
    @GetMapping("/list")
    public TableDataInfo list(MdConfig mdConfig) {
        startPage();
        List<MdConfig> list = mdConfigService.selectMdConfigList(mdConfig);
        return getDataTable(list);
    }

    /**
     * 导出推荐配置列表
     */
    @PreAuthorize(hasPermi = "system:mdconfig:export")
    @Log(title = "推荐配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdConfig mdConfig) throws IOException {
        List<MdConfig> list = mdConfigService.selectMdConfigList(mdConfig);
        ExcelUtil<MdConfig> util = new ExcelUtil<MdConfig>(MdConfig.class);
        util.exportExcel(response, list, "mdconfig");
    }

    /**
     * 获取推荐配置详细信息
     */
    @PreAuthorize(hasPermi = "system:mdconfig:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(mdConfigService.selectMdConfigById(id));
    }

    /**
     * 新增推荐配置
     */
    @PreAuthorize(hasPermi = "system:mdconfig:add")
    @Log(title = "推荐配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdConfig mdConfig) {
        return toAjax(mdConfigService.insertMdConfig(mdConfig));
    }

    /**
     * 修改推荐配置
     */
    @PreAuthorize(hasPermi = "system:mdconfig:edit")
    @Log(title = "推荐配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdConfig mdConfig) {
        return toAjax(mdConfigService.updateMdConfig(mdConfig));
    }

    /**
     * 删除推荐配置
     */
    @PreAuthorize(hasPermi = "system:mdconfig:remove")
    @Log(title = "推荐配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(mdConfigService.deleteMdConfigByIds(ids));
    }
}
