package com.cms.xh.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.cms.xh.domain.MdXhUsers;
import com.cms.xh.domain.vo.MdXhUsersVO;
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
import com.cms.xh.service.IMdXhUsersService;
import com.cms.common.core.web.controller.BaseController;
import com.cms.common.core.web.domain.AjaxResult;
import com.cms.common.core.utils.poi.ExcelUtil;
import com.cms.common.core.web.page.TableDataInfo;

/**
 * 用户信息Controller
 *
 * @author lhy
 * @date 2023-05-08
 */
@RestController
@RequestMapping("/users")
public class MdXhUsersController extends BaseController {
    @Autowired
    private IMdXhUsersService mdXhUsersService;

    /**
     * 查询用户信息列表
     */
    @PreAuthorize(hasPermi = "system:users:list")
    @GetMapping("/list")
    public TableDataInfo list(MdXhUsersVO mdXhUsers) {
        startPage();
        List<MdXhUsersVO> list = mdXhUsersService.selectMdXhUsersList(mdXhUsers);
        return getDataTable(list);
    }

    /**
     * 导出用户信息列表
     */
    @PreAuthorize(hasPermi = "system:users:export")
    @Log(title = "用户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MdXhUsersVO mdXhUsers) throws IOException {
        List<MdXhUsersVO> list = mdXhUsersService.selectMdXhUsersList(mdXhUsers);
        ExcelUtil<MdXhUsersVO> util = new ExcelUtil<MdXhUsersVO>(MdXhUsersVO.class);
        util.exportExcel(response, list, "users");
    }

    /**
     * 获取用户信息详细信息
     */
    @PreAuthorize(hasPermi = "system:users:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(mdXhUsersService.selectMdXhUsersById(id));
    }

    /**
     * 新增用户信息
     */
    @PreAuthorize(hasPermi = "system:users:add")
    @Log(title = "用户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MdXhUsers mdXhUsers) {
        return toAjax(mdXhUsersService.insertMdXhUsers(mdXhUsers));
    }

    /**
     * 修改用户信息
     */
    @PreAuthorize(hasPermi = "system:users:edit")
    @Log(title = "用户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MdXhUsers mdXhUsers) {
        return toAjax(mdXhUsersService.updateMdXhUsers(mdXhUsers));
    }

    /**
     * 删除用户信息
     */
    @PreAuthorize(hasPermi = "system:users:remove")
    @Log(title = "用户信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(mdXhUsersService.deleteMdXhUsersByIds(ids));
    }
}
