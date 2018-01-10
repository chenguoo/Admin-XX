package com.javamokey.adminxx.modules.sys.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.javamokey.adminxx.common.annotation.SysLog;
import com.javamokey.adminxx.common.util.Constant;
import com.javamokey.adminxx.common.util.PageUtils;
import com.javamokey.adminxx.common.util.R;
import com.javamokey.adminxx.modules.sys.entity.SysRole;
import com.javamokey.adminxx.modules.sys.entity.vo.SysRoleVo;
import com.javamokey.adminxx.modules.sys.service.SysRoleDeptService;
import com.javamokey.adminxx.modules.sys.service.SysRoleMenuService;
import com.javamokey.adminxx.modules.sys.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        page = sysRoleService.selectSysRoleVoPage(page);

//        PageUtils pageUtil = new PageUtils(page.getRecords(), page.getTotal(), page.getLimit(), page.getCurrent());

        return R.ok().put("page", page);
    }

}

