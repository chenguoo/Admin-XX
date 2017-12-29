package com.javamokey.adminxx.modules.sys.controller;


import com.javamokey.adminxx.common.util.R;
import com.javamokey.adminxx.modules.sys.entity.SysMenu;
import com.javamokey.adminxx.modules.sys.service.SysMenuService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
@RestController
@RequestMapping("/sys/sysMenu")
public class SysMenuController extends AbstractController{

    private final SysMenuService sysMenuService;

    public SysMenuController(SysMenuService sysMenuService) {
        this.sysMenuService = sysMenuService;
    }

    /**
     * 导航菜单
     */
    @RequestMapping("/nav")
    public R nav(){
        List<SysMenu> menuList = sysMenuService.getUserMenuList(getUserId());
        return R.ok().put("menuList", menuList);
    }

}

