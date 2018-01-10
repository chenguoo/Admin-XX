package com.javamokey.adminxx.modules.sys.entity.vo;

import com.javamokey.adminxx.modules.sys.entity.SysRole;

import java.util.List;

/**
 * 说明:
 *
 * @author Cheney <br>
 * modified by :
 * @version 1.0 <br>
 * Created in 2018-01-10 16:21
 */
public class SysRoleVo extends SysRole{

    /**
     * 部门名称
     */
    private String deptName;

    private List<Long> menuIdList;

    private List<Long> deptIdList;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Long> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Long> menuIdList) {
        this.menuIdList = menuIdList;
    }

    public List<Long> getDeptIdList() {
        return deptIdList;
    }

    public void setDeptIdList(List<Long> deptIdList) {
        this.deptIdList = deptIdList;
    }
}
