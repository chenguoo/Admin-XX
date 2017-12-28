package com.javamokey.adminxx.modules.sys.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 系统配置信息表
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
public class SysConfig implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * key
     */
	private String key;
    /**
     * value
     */
	private String value;
    /**
     * 状态   0：隐藏   1：显示
     */
	private Integer status;
    /**
     * 备注
     */
	private String remark;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "SysConfig{" +
			"id=" + id +
			", key=" + key +
			", value=" + value +
			", status=" + status +
			", remark=" + remark +
			"}";
	}
}
