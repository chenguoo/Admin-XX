package com.javamokey.adminxx.modules.sys.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.javamokey.adminxx.common.annotation.SysLogAnnotation;
import com.javamokey.adminxx.common.exception.AppException;
import com.javamokey.adminxx.common.util.Constant;
import com.javamokey.adminxx.common.util.R;
import com.javamokey.adminxx.modules.sys.entity.SysMenu;
import com.javamokey.adminxx.modules.sys.entity.vo.SysMenuVo;
import com.javamokey.adminxx.modules.sys.service.SysMenuService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/sys/menu")
public class SysMenuController extends AbstractController {

    private final SysMenuService sysMenuService;

    public SysMenuController(SysMenuService sysMenuService) {
        this.sysMenuService = sysMenuService;
    }

    /**
     * 主页面导航菜单
     */
    @RequestMapping("/nav")
    public R nav() {

        List<SysMenuVo> menuList = sysMenuService.getUserMenuList(getUserId());
        return R.ok().put("menuList", menuList);
    }

    /**
     * 所有菜单列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:menu:list")
    public List<SysMenuVo> list() {

        List<SysMenuVo> menuList = sysMenuService.queryList();

        return menuList;
    }

    /**
     * 选择菜单(添加、修改菜单)
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:menu:select")
    public R select() {
        //查询列表数据
//        List<SysMenuVo> menuList = sysMenuService.queryNotButtonList();

        EntityWrapper<SysMenu> wrapper = new EntityWrapper<>();
        wrapper.in("type",new String[]{"0","1"});
        List<SysMenu> menuList =sysMenuService.selectList(wrapper);

        //添加顶级菜单
        SysMenuVo root = new SysMenuVo();
        root.setMenuId(0L);
        root.setName("一级菜单");
        root.setParentId(-1L);
        root.setOpen(true);
        menuList.add(root);

        return R.ok().put("menuList", menuList);
    }

    /**
     * 菜单信息
     */
    @RequestMapping("/info/{menuId}")
    @RequiresPermissions("sys:menu:info")
    public R info(@PathVariable("menuId") Long menuId) {
        SysMenu menu = sysMenuService.selectById(menuId);

        return R.ok().put("menu", menu);
    }

    /**
     * 保存
     */
    @SysLogAnnotation("保存菜单")
    @RequestMapping("/save")
    @RequiresPermissions("sys:menu:save")
    public R save(@RequestBody SysMenu menu) {
        //数据校验
        verifyForm(menu);

        sysMenuService.insert(menu);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLogAnnotation("修改菜单")
    @RequestMapping("/update")
    @RequiresPermissions("sys:menu:update")
    public R update(@RequestBody SysMenu menu) {
        //数据校验
        verifyForm(menu);

        sysMenuService.updateById(menu);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLogAnnotation("删除菜单")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:menu:delete")
    public R delete(long menuId) {
        if (menuId <= 31) {
            return R.error("系统菜单，不能删除");
        }

        //判断是否有子菜单或按钮
        List<SysMenuVo> menuList = sysMenuService.queryListParentId(menuId);
        if (menuList.size() > 0) {
            return R.error("请先删除子菜单或按钮");
        }

        sysMenuService.deleteById(menuId);

        return R.ok();
    }

    /**
     * 验证参数是否正确
     */
    private void verifyForm(SysMenu menu) {
        if (StringUtils.isBlank(menu.getName())) {
            throw new AppException("菜单名称不能为空");
        }

        if (menu.getParentId() == null) {
            throw new AppException("上级菜单不能为空");
        }

        //菜单
        if (menu.getType() == Constant.MenuType.MENU.getValue()) {
            if (StringUtils.isBlank(menu.getUrl())) {
                throw new AppException("菜单URL不能为空");
            }
        }

        //上级菜单类型
        int parentType = Constant.MenuType.CATALOG.getValue();
        if (menu.getParentId() != 0) {
            SysMenu parentMenu = sysMenuService.selectById(menu.getParentId());
            parentType = parentMenu.getType();
        }

        //目录、菜单
        if (menu.getType() == Constant.MenuType.CATALOG.getValue() ||
                menu.getType() == Constant.MenuType.MENU.getValue()) {
            if (parentType != Constant.MenuType.CATALOG.getValue()) {
                throw new AppException("上级菜单只能为目录类型");
            }
            return;
        }

        //按钮
        if (menu.getType() == Constant.MenuType.BUTTON.getValue()) {
            if (parentType != Constant.MenuType.MENU.getValue()) {
                throw new AppException("上级菜单只能为菜单类型");
            }
            return;
        }
    }
}

