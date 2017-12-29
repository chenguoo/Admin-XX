package com.javamokey.adminxx.modules.sys.service;

import com.javamokey.adminxx.modules.sys.entity.SysMenu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 获取用户菜单列表
     */
    List<SysMenu> getUserMenuList(Long userId);
    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     * @param menuIdList  用户菜单ID
     */
    List<SysMenu> queryListParentId(Long parentId, List<Long> menuIdList);

    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    List<SysMenu> queryListParentId(Long parentId);

}
