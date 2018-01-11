package com.javamokey.adminxx.modules.sys.service;

import com.javamokey.adminxx.modules.sys.entity.SysRoleMenu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 角色与菜单对应关系 服务类
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {

    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<Long> queryMenuIdList(Long roleId);

    void saveOrUpdate(Long roleId, List<Long> menuIdList);

}
