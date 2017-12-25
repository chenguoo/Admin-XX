package com.javamokey.adminxx.modules.sys.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Cheney
 * @since 2017-12-25
 */
public class SysUserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

	private Long userId;
	private String userInfo;


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "SysUserInfo{" +
			"userId=" + userId +
			", userInfo=" + userInfo +
			"}";
	}
}
