package com.javamokey.adminxx.modules.sys.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 部门管理
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
public class SysDept implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="dept_id", type= IdType.AUTO)
	private Long deptId;
    /**
     * 上级部门ID，一级部门为0
     */
	private Long parentId;
    /**
     * 部门名称
     */
	private String name;
    /**
     * 排序
     */
	private Integer orderNum;
    /**
     * 是否删除  -1：已删除  0：正常
     */
	private Integer delFlag;


	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public String toString() {
		return "SysDept{" +
			"deptId=" + deptId +
			", parentId=" + parentId +
			", name=" + name +
			", orderNum=" + orderNum +
			", delFlag=" + delFlag +
			"}";
	}
}
