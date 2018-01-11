package com.javamokey.adminxx.modules.sys.mapper;

import com.javamokey.adminxx.modules.sys.entity.SysRoleMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 角色与菜单对应关系 Mapper 接口
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    List<Long> queryMenuIdList(Long roleId);
}
