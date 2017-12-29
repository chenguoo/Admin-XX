package com.javamokey.adminxx.modules.sys.service;

import com.javamokey.adminxx.modules.sys.entity.SysUser;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);

}
