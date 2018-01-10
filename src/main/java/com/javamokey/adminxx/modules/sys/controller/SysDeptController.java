package com.javamokey.adminxx.modules.sys.controller;


import com.javamokey.adminxx.common.util.Constant;
import com.javamokey.adminxx.common.util.R;
import com.javamokey.adminxx.modules.sys.entity.SysDept;
import com.javamokey.adminxx.modules.sys.entity.vo.SysDeptVo;
import com.javamokey.adminxx.modules.sys.service.SysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}

