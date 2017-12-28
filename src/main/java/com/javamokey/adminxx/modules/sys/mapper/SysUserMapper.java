package com.javamokey.adminxx.modules.sys.mapper;

import com.javamokey.adminxx.modules.sys.entity.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    List<String> queryAllPerms(Long userId);
    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 根据用户名，查询系统用户
     */
    SysUser queryByUserName(String username);

}
