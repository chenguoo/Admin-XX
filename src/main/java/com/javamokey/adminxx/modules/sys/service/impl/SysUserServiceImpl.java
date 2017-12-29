package com.javamokey.adminxx.modules.sys.service.impl;

import com.javamokey.adminxx.modules.sys.entity.SysUser;
import com.javamokey.adminxx.modules.sys.mapper.SysUserMapper;
import com.javamokey.adminxx.modules.sys.service.SysUserRoleService;
import com.javamokey.adminxx.modules.sys.service.SysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private SysUserMapper sysUserMapper;
    private SysUserRoleService sysUserRoleService;

    public SysUserServiceImpl(SysUserMapper sysUserMapper, SysUserRoleService sysUserRoleService) {
        this.sysUserMapper = sysUserMapper;
        this.sysUserRoleService = sysUserRoleService;
    }

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return sysUserMapper.queryAllMenuId(userId);
    }
}
