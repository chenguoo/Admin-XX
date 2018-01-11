package com.javamokey.adminxx.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.javamokey.adminxx.modules.sys.entity.SysRoleDept;
import com.javamokey.adminxx.modules.sys.entity.SysRoleMenu;
import com.javamokey.adminxx.modules.sys.mapper.SysRoleDeptMapper;
import com.javamokey.adminxx.modules.sys.service.SysRoleDeptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色与部门对应关系 服务实现类
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
@Service
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptMapper, SysRoleDept> implements SysRoleDeptService {

    private SysRoleDeptMapper sysRoleDeptMapper;

    public SysRoleDeptServiceImpl(SysRoleDeptMapper sysRoleDeptMapper) {
        this.sysRoleDeptMapper = sysRoleDeptMapper;
    }

    @Override
    public List<Long> queryDeptIdList(Long roleId) {
        return sysRoleDeptMapper.queryDeptIdList(roleId);
    }

    @Override
    public void saveOrUpdate(Long roleId, List<Long> deptIdList) {
        //先删除角色与部门关系
        EntityWrapper<SysRoleDept> wrapper = new EntityWrapper<>();
        wrapper.eq("role_id", roleId);
        sysRoleDeptMapper.delete(wrapper);

        if (deptIdList.size() == 0) {
            return;
        }

        //保存角色与菜单关系
        for (Long deptId : deptIdList) {
            SysRoleDept sysRoleDept = new SysRoleDept(roleId, deptId);
            sysRoleDeptMapper.insert(sysRoleDept);
        }
    }
}
