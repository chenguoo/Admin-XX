package com.javamokey.adminxx.modules.sys.service.impl;

import com.javamokey.adminxx.common.util.Constant;
import com.javamokey.adminxx.modules.sys.entity.SysMenu;
import com.javamokey.adminxx.modules.sys.entity.vo.SysMenuVo;
import com.javamokey.adminxx.modules.sys.mapper.SysMenuMapper;
import com.javamokey.adminxx.modules.sys.service.SysMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.javamokey.adminxx.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    private final SysMenuMapper sysMenuMapper;
    private final SysUserService sysUserService;

    public SysMenuServiceImpl(SysMenuMapper sysMenuMapper, SysUserService sysUserService) {
        this.sysMenuMapper = sysMenuMapper;
        this.sysUserService = sysUserService;
    }

    @Override
    public List<SysMenuVo> getUserMenuList(Long userId) {
        //系统管理员，拥有最高权限
        if (userId == Constant.SUPER_ADMIN) {
            return getAllMenuList(null);
        }

        //用户菜单列表
        List<Long> menuIdList = sysUserService.queryAllMenuId(userId);
        return getAllMenuList(menuIdList);
    }

    /**
     * 获取所有菜单列表
     */
    private List<SysMenuVo> getAllMenuList(List<Long> menuIdList) {
        //查询根菜单列表
        List<SysMenuVo> menuList = queryListParentId(0L, menuIdList);
        //递归获取子菜单
        getMenuTreeList(menuList, menuIdList);

        return menuList;
    }

    @Override
    public List<SysMenuVo> queryListParentId(Long parentId, List<Long> menuIdList) {
        List<SysMenuVo> menuList = queryListParentId(parentId);
        if (menuIdList == null) {
            return menuList;
        }

        List<SysMenuVo> userMenuList = new ArrayList<>();
        for (SysMenuVo menu : menuList) {
            if (menuIdList.contains(menu.getMenuId())) {
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }

    @Override
    public List<SysMenuVo> queryListParentId(Long parentId) {
        return sysMenuMapper.queryListParentId(parentId);

    }

    /**
     * 递归
     */
    private List<SysMenuVo> getMenuTreeList(List<SysMenuVo> menuList, List<Long> menuIdList) {
        List<SysMenuVo> subMenuList = new ArrayList<SysMenuVo>();

        for (SysMenuVo entity : menuList) {
            if (entity.getType() == Constant.MenuType.CATALOG.getValue()) {//目录
                entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
            }
            subMenuList.add(entity);
        }

        return subMenuList;
    }
}
