package com.javamokey.adminxx.modules.sys.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 文件上传
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
public class SysOss implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * URL地址
     */
	private String url;
    /**
     * 创建时间
     */
	private Date createDate;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "SysOss{" +
			"id=" + id +
			", url=" + url +
			", createDate=" + createDate +
			"}";
	}
}
