package com.cms.xh.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cms.common.log.annotation.Log;
import com.cms.common.log.enums.BusinessType;
import com.cms.common.security.annotation.PreAuthorize;
import com.cms.xh.domain.MdXhVideos;
import com.cms.xh.service.IMdXhVideosService;
import com.cms.common.core.web.controller.BaseController;
import com.cms.common.core.web.domain.AjaxResult;
import com.cms.common.core.utils.poi.ExcelUtil;
import com.cms.common.core.web.page.TableDataInfo;

/**
 * 视频信息Controller
 *
 * @author lhy
 * @date 2023-05-08
 */
@RestController
@RequestMapping("/videos")
public class MdXhVideosController extends BaseController {
    @Autowired
    private IMdXhVideosService mdXhVideosService;

    /**
     * 查询视频信息列表
     */
    @PreAuthorize(hasPermi = "system:videos:list")
    @GetMapping("/list")
    public TableDataInfo list(MdXhVideos mdXhVideos) {
        startPage();
        List<MdXhVideos> list = mdXhVideosService.selectMdXhVideosList(mdXhVideos);
        return getDataTable(list);
    }

    /**
     * 导出视频信息列表
     */
    @PreAuthorize(hasPermi = "system:videos:export")
    @Log(title = "视频信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdXhVideos mdXhVideos) throws IOException {
        List<MdXhVideos> list = mdXhVideosService.selectMdXhVideosList(mdXhVideos);
        ExcelUtil<MdXhVideos> util = new ExcelUtil<MdXhVideos>(MdXhVideos.class);
        util.exportExcel(response, list, "videos");
    }

    /**
     * 获取视频信息详细信息
     */
    @PreAuthorize(hasPermi = "system:videos:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(mdXhVideosService.selectMdXhVideosById(id));
    }

    /**
     * 新增视频信息
     */
    @PreAuthorize(hasPermi = "system:videos:add")
    @Log(title = "视频信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdXhVideos mdXhVideos) {
        return toAjax(mdXhVideosService.insertMdXhVideos(mdXhVideos));
    }

    /**
     * 修改视频信息
     */
    @PreAuthorize(hasPermi = "system:videos:edit")
    @Log(title = "视频信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdXhVideos mdXhVideos) {
        return toAjax(mdXhVideosService.updateMdXhVideos(mdXhVideos));
    }

    /**
     * 删除视频信息
     */
    @PreAuthorize(hasPermi = "system:videos:remove")
    @Log(title = "视频信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(mdXhVideosService.deleteMdXhVideosByIds(ids));
    }


    /**
     * 根据用户 ID 累计用户观看次数
     *
     * @param userId 用户 ID
     * @return
     */
    @Log(title = "视频信息", businessType = BusinessType.UPDATE)
    @PostMapping("/updateUserWatchCount")
    public AjaxResult updateUserWatchCount(@RequestParam("userId") Long userId) {
        return toAjax(mdXhVideosService.updateUserWatchCount(userId));
    }

    /**
     * 根据用户 ID 累计用户观看时间
     *
     * @param userId    用户 ID
     * @param watchTime 用户观看时间
     * @return
     */
    @Log(title = "视频信息", businessType = BusinessType.UPDATE)
    @PostMapping("/updateUserWatchTime")
    public AjaxResult updateUserWatchTime(@RequestParam("userId") Long userId,
                                          @RequestParam("watchTime") Long watchTime) {
        return toAjax(mdXhVideosService.updateUserWatchTime(userId, watchTime));
    }

    /**
     * 获取视频信息详细信息
     */
    @GetMapping(value = "/getVideoInfo")
    public AjaxResult getInfo() {
        return AjaxResult.success(mdXhVideosService.selectMdXhVideos());
    }

}
