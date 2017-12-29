package com.javamokey.adminxx.modules.sys.controller;


import com.javamokey.adminxx.common.util.R;
import com.javamokey.adminxx.modules.sys.service.SysUserRoleService;
import com.javamokey.adminxx.modules.sys.service.SysUserService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
@RestController
@RequestMapping("/sys/sysUser")
public class SysUserController  extends AbstractController{

    private final SysUserService sysUserService;
    private final SysUserRoleService sysUserRoleService;

    public SysUserController(SysUserService sysUserService, SysUserRoleService sysUserRoleService) {
        this.sysUserService = sysUserService;
        this.sysUserRoleService = sysUserRoleService;
    }

    /**
     * 获取登录的用户信息
     */
    @RequestMapping("/info")
    public R info(){
        return R.ok().put("user", getUser());
    }


}

