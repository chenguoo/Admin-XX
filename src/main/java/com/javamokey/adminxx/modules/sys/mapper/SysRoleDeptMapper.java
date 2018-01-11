package com.javamokey.adminxx.modules.sys.mapper;

import com.javamokey.adminxx.modules.sys.entity.SysRoleDept;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色与部门对应关系 Mapper 接口
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
public interface SysRoleDeptMapper extends BaseMapper<SysRoleDept> {

    /**
     * 根据角色ID，获取部门ID列表
     */
    List<Long> queryDeptIdList(Long roleId);

}
