package com.javamokey.adminxx.modules.sys.service;

import com.javamokey.adminxx.modules.sys.entity.SysRoleDept;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 角色与部门对应关系 服务类
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
public interface SysRoleDeptService extends IService<SysRoleDept> {
    /**
     * 根据角色ID，获取部门ID列表
     */
    List<Long> queryDeptIdList(Long roleId);

    void saveOrUpdate(Long roleId, List<Long> deptIdList);
}
