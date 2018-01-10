package com.javamokey.adminxx.modules.sys.entity.vo;

import com.javamokey.adminxx.modules.sys.entity.SysDept;

/**
 * 说明:
 *
 * @author Cheney <br>
 * modified by :
 * @version 1.0 <br>
 * Created in 2018-01-08 11:50
 */
public class SysDeptVo extends SysDept{

    /**
     * 上级部门名称
     */
    private String parentName;
    /**
     * ztree属性
     */
    private Boolean open;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }


    @Override
    public String toString() {
        return "SysDeptVo{" +
                "parentName='" + parentName + '\'' +
                ", open=" + open +
                "} " + super.toString();
    }
}
