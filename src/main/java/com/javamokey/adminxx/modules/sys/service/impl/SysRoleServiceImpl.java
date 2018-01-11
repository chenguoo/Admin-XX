package com.javamokey.adminxx.modules.sys.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.javamokey.adminxx.common.exception.AppException;
import com.javamokey.adminxx.modules.sys.entity.SysRole;
import com.javamokey.adminxx.modules.sys.entity.vo.SysRoleVo;
import com.javamokey.adminxx.modules.sys.mapper.SysRoleMapper;
import com.javamokey.adminxx.modules.sys.service.SysRoleDeptService;
import com.javamokey.adminxx.modules.sys.service.SysRoleMenuService;
import com.javamokey.adminxx.modules.sys.service.SysRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    private SysRoleMapper sysRoleMapper;
    private SysRoleMenuService sysRoleMenuService;
    private SysRoleDeptService sysRoleDeptService;

    public SysRoleServiceImpl(SysRoleMapper sysRoleMapper,
                              SysRoleMenuService sysRoleMenuService,
                              SysRoleDeptService sysRoleDeptService) {
        this.sysRoleMapper = sysRoleMapper;
        this.sysRoleMenuService = sysRoleMenuService;
        this.sysRoleDeptService = sysRoleDeptService;
    }

    @Override
    public Page<SysRoleVo> querySysRoleVoPage(Page<SysRoleVo> page) {
        return page.setRecords(sysRoleMapper.querySysRoleVoPage(page));
    }

    @Override
    public SysRoleVo querySysRoleVoById(Long roleId) {
        return sysRoleMapper.querySysRoleVoById(roleId);
    }

    @Override
    public void deleteBatch(Long[] roleIds) {
        sysRoleMapper.deleteBatch(roleIds);
    }

    @Override
    public void save(SysRoleVo role) {
        role.setCreateTime(new Date());

        sysRoleMapper.insert((SysRole) role);

        //保存角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());

        //保存角色与部门关系
        sysRoleDeptService.saveOrUpdate(role.getRoleId(), role.getDeptIdList());
    }

    @Override
    public void update(SysRoleVo role) {

        sysRoleMapper.updateById((SysRole) role);

        //更新角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());

//        throw new AppException("测试事务回滚");
        //保存角色与部门关系
        sysRoleDeptService.saveOrUpdate(role.getRoleId(), role.getDeptIdList());
    }
}
