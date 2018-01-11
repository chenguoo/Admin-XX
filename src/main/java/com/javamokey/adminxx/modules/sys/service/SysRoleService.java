package com.javamokey.adminxx.modules.sys.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.javamokey.adminxx.modules.sys.entity.SysRole;
import com.baomidou.mybatisplus.service.IService;
import com.javamokey.adminxx.modules.sys.entity.vo.SysRoleVo;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     * 分页查询角色列表
     * @param page
     * @return
     */
    Page<SysRoleVo> querySysRoleVoPage(Page<SysRoleVo> page);

    SysRoleVo querySysRoleVoById(Long roleId);

    void deleteBatch(Long[] roleIds);

    /**
     * 保存角色信息
     * @param role
     */
    void save(SysRoleVo role);

    void update(SysRoleVo role);
}
