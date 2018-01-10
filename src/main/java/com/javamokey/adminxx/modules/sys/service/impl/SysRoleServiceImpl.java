package com.javamokey.adminxx.modules.sys.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.javamokey.adminxx.modules.sys.entity.SysRole;
import com.javamokey.adminxx.modules.sys.entity.vo.SysRoleVo;
import com.javamokey.adminxx.modules.sys.mapper.SysRoleMapper;
import com.javamokey.adminxx.modules.sys.service.SysRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public SysRoleServiceImpl(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    @Override
    public Page<SysRoleVo> selectSysRoleVoPage(Page<SysRoleVo> page) {
        return page.setRecords(sysRoleMapper.selectSysRoleVoPage(page));
    }
}
