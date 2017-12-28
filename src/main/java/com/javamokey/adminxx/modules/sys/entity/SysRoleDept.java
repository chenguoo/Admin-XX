package com.javamokey.adminxx.modules.sys.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 角色与部门对应关系
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
public class SysRoleDept implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 角色ID
     */
	private Long roleId;
    /**
     * 部门ID
     */
	private Long deptId;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "SysRoleDept{" +
			"id=" + id +
			", roleId=" + roleId +
			", deptId=" + deptId +
			"}";
	}
}
