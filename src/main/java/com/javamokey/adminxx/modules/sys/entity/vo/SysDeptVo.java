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

    //上级部门名称
    private String parentName;


    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }


    @Override
    public String toString() {
        return "SysDeptVo{" +
                "parentName='" + parentName + '\'' +
                "} " + super.toString();
    }
}
