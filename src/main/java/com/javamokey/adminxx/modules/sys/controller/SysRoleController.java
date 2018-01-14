package com.javamokey.adminxx.modules.sys.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.javamokey.adminxx.common.annotation.SysLogAnnotation;
import com.javamokey.adminxx.common.util.Constant;
import com.javamokey.adminxx.common.util.R;
import com.javamokey.adminxx.common.validator.ValidatorUtils;
import com.javamokey.adminxx.modules.sys.entity.vo.SysRoleVo;
import com.javamokey.adminxx.modules.sys.service.SysRoleDeptService;
import com.javamokey.adminxx.modules.sys.service.SysRoleMenuService;
import com.javamokey.adminxx.modules.sys.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {

    private SysRoleService sysRoleService;
    private SysRoleMenuService sysRoleMenuService;
    private SysRoleDeptService sysRoleDeptService;

    public SysRoleController(SysRoleService sysRoleService,
                             SysRoleMenuService sysRoleMenuService,
                             SysRoleDeptService sysRoleDeptService) {
        this.sysRoleService = sysRoleService;
        this.sysRoleMenuService = sysRoleMenuService;
        this.sysRoleDeptService = sysRoleDeptService;
    }


    /**
     * 角色列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:role:list")
    public R list(Pagination params) {
        //如果不是超级管理员，则只查询自己创建的角色列表
        if (getUserId() != Constant.SUPER_ADMIN) {
//            params.put("createUserId", getUserId());
            //page.setCondition()
        }
        //查询列表数据
        Page<SysRoleVo> page = new Page<>(params.getCurrent(), params.getSize());
//        page.setCurrent(Integer.parseInt((String)params.get("page")))
//                .setSize(10);
        page = sysRoleService.querySysRoleVoPage(page);

//        PageUtils pageUtil = new PageUtils(page.getRecords(), page.getTotal(), page.getLimit(), page.getCurrent());

        return R.ok().put("page", page);
    }


    /**
     * 角色信息
     */
    @RequestMapping("/info/{roleId}")
    @RequiresPermissions("sys:role:info")
    public R info(@PathVariable("roleId") Long roleId) {

        SysRoleVo role = sysRoleService.querySysRoleVoById(roleId);

        //查询角色对应的菜单
        List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
        role.setMenuIdList(menuIdList);

        //查询角色对应的部门
        List<Long> deptIdList = sysRoleDeptService.queryDeptIdList(roleId);
        role.setDeptIdList(deptIdList);

        return R.ok().put("role", role);
    }

    /**
     * 保存角色
     */
    @SysLogAnnotation("保存角色")
    @RequestMapping("/save")
    @RequiresPermissions("sys:role:save")
    public R save(@RequestBody SysRoleVo role) {

        ValidatorUtils.validateEntity(role);

        sysRoleService.save(role);

        return R.ok();
    }


    /**
     * 修改角色
     */
    @SysLogAnnotation("修改角色")
    @RequestMapping("/update")
    @RequiresPermissions("sys:role:update")
    public R update(@RequestBody SysRoleVo role) {
        ValidatorUtils.validateEntity(role);

        sysRoleService.update(role);

        return R.ok();
    }

    /**
     * 删除角色
     */
    @SysLogAnnotation("删除角色")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public R delete(@RequestBody Long[] roleIds) {
        sysRoleService.deleteBatch(roleIds);

        return R.ok();
    }
}

