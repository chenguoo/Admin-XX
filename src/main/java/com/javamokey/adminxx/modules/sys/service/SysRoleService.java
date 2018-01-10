package com.javamokey.adminxx.modules.sys.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.javamokey.adminxx.modules.sys.entity.SysRole;
import com.baomidou.mybatisplus.service.IService;
import com.javamokey.adminxx.modules.sys.entity.vo.SysRoleVo;

import java.util.List;

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
    Page<SysRoleVo> selectSysRoleVoPage(Page<SysRoleVo> page);
}
