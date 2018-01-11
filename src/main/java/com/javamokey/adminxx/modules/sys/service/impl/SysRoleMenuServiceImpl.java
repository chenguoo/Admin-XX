package com.javamokey.adminxx.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.javamokey.adminxx.modules.sys.entity.SysRole;
import com.javamokey.adminxx.modules.sys.entity.SysRoleMenu;
import com.javamokey.adminxx.modules.sys.mapper.SysRoleMenuMapper;
import com.javamokey.adminxx.modules.sys.service.SysRoleMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色与菜单对应关系 服务实现类
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    private SysRoleMenuMapper sysRoleMenuMapper;

    public SysRoleMenuServiceImpl(SysRoleMenuMapper sysRoleMenuMapper) {
        this.sysRoleMenuMapper = sysRoleMenuMapper;
    }

    @Override
    public List<Long> queryMenuIdList(Long roleId) {
        return sysRoleMenuMapper.queryMenuIdList(roleId);
    }

    @Override
    public void saveOrUpdate(Long roleId, List<Long> menuIdList) {
        //先删除角色与菜单关系
        EntityWrapper<SysRoleMenu> wrapper = new EntityWrapper<>();
        wrapper.eq("role_id", roleId);
        sysRoleMenuMapper.delete(wrapper);

        if (menuIdList.size() == 0) {
            return;
        }

        //保存角色与菜单关系
        Map<String, Object> map = new HashMap<>();
        map.put("roleId", roleId);
        map.put("menuIdList", menuIdList);
        for (Long menuId : menuIdList) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu(roleId, menuId);
            sysRoleMenuMapper.insert(sysRoleMenu);
        }
    }
}
