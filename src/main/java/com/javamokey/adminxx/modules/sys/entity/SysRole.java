package com.javamokey.adminxx.modules.sys.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="role_id", type= IdType.AUTO)
	private Long roleId;
    /**
     * 角色名称
     */
	private String roleName;
    /**
     * 备注
     */
	private String remark;
    /**
     * 部门ID
     */
	private Long deptId;
    /**
     * 创建时间
     */
	private Date createTime;


	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SysRole{" +
			"roleId=" + roleId +
			", roleName=" + roleName +
			", remark=" + remark +
			", deptId=" + deptId +
			", createTime=" + createTime +
			"}";
	}
}
