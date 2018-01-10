package com.javamokey.adminxx.modules.sys.entity.vo;

import com.javamokey.adminxx.modules.sys.entity.SysMenu;

import java.util.List;

/**
 * 说明:
 *
 * @author Cheney <br>
 * modified by :
 * @version 1.0 <br>
 * Created in 2018-01-08 14:45
 */
public class SysMenuVo extends SysMenu {
    /**
     * 父菜单名称
     */
    private String parentName;
    /**
     * ztree属性
     */
    private Boolean open;

    /**
     * 子菜单
     */
    private List<?> list;



    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

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
        return "SysMenuVo{" +
                "parentName='" + parentName + '\'' +
                ", open=" + open +
                ", list=" + list +
                "} " + super.toString();
    }
}
