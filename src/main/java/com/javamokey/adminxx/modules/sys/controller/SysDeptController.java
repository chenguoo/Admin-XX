package com.javamokey.adminxx.modules.sys.controller;


import com.javamokey.adminxx.common.util.Constant;
import com.javamokey.adminxx.common.util.R;
import com.javamokey.adminxx.modules.sys.entity.SysDept;
import com.javamokey.adminxx.modules.sys.entity.vo.SysDeptVo;
import com.javamokey.adminxx.modules.sys.service.SysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 部门管理 前端控制器
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
@RestController
@RequestMapping("/sys/dept")
public class SysDeptController extends AbstractController {

    private SysDeptService sysDeptService;

    public SysDeptController(SysDeptService sysDeptService) {
        this.sysDeptService = sysDeptService;
    }

    /**
     * 获取上级部门Id(管理员则为0)
     */
    @RequestMapping("/getDeptIdInfo")
    @RequiresPermissions("sys:dept:list")
    public R getDeptIdInfo() {
        long deptId = 0;
        if (getUserId() != Constant.SUPER_ADMIN) {
            SysDept dept = sysDeptService.selectById(getDeptId());
            deptId = dept.getParentId();
        }

        return R.ok().put("deptId", deptId);

    }

    /**
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:dept:list")
    public List<SysDeptVo> list() {

        List<SysDeptVo> deptList = sysDeptService.querySysDeptVoList(new SysDeptVo());

        return deptList;
    }


    /**
     * 获取部门详细信息
     */
    @RequestMapping("/info/{deptId}")
    @RequiresPermissions("sys:dept:info")
    public R info(@PathVariable("deptId") Long deptId) {

        SysDeptVo dept = sysDeptService.selectSysDeptVoById(deptId);

        return R.ok().put("dept", dept);
    }

    /**
     * 选择部门(添加、修改菜单)
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:dept:select")
    public R select() {
        List<SysDeptVo> deptList = sysDeptService.querySysDeptVoList(new SysDeptVo());

        //添加一级部门
        if (getUserId() == Constant.SUPER_ADMIN) {
            SysDeptVo root = new SysDeptVo();
            root.setDeptId(0L);
            root.setName("一级部门");
            root.setParentId(-1L);
            root.setOpen(true);
            deptList.add(root);
        }

        return R.ok().put("deptList", deptList);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:dept:save")
    public R save(@RequestBody SysDept dept) {

        sysDeptService.insertOrUpdate(dept);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:dept:update")
    public R update(@RequestBody SysDept dept) {

        sysDeptService.insertOrUpdate(dept);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:dept:delete")
    public R delete(@PathVariable(value = "deptId", required = true) long deptId) {
        //判断是否有子部门
        SysDeptVo sysDeptVo = new SysDeptVo();
        sysDeptVo.setParentId(deptId);
        List<SysDeptVo> deptList = sysDeptService.querySysDeptVoList(sysDeptVo);
        if (deptList.size() > 0) {
            return R.error("请先删除子部门");
        }

        if (sysDeptService.deleteById(deptId)) {
            return R.ok();
        } else {
            return R.error("没有删除到记录");
        }
    }
}

