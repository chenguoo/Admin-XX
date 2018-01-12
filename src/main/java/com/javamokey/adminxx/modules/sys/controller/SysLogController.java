package com.javamokey.adminxx.modules.sys.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.javamokey.adminxx.common.util.PageUtils;
import com.javamokey.adminxx.common.util.R;
import com.javamokey.adminxx.common.util.StringUtil;
import com.javamokey.adminxx.modules.sys.entity.SysLog;
import com.javamokey.adminxx.modules.sys.entity.vo.SysRoleVo;
import com.javamokey.adminxx.modules.sys.service.SysLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统日志 前端控制器
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
@RestController
@RequestMapping("/sys/log")
public class SysLogController {

    private SysLogService sysLogService;

    public SysLogController(SysLogService sysLogService) {
        this.sysLogService = sysLogService;
    }


    /**
     * 日志列表
     *
     * @param params
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:log:list")
    public R list(Pagination params) {
        //查询列表数据
        Page<SysLog> page = new Page<>(params.getCurrent(), params.getSize());

        EntityWrapper<SysLog> wrapper = new EntityWrapper<>();

//        if(!StringUtil.isEmpty(key)){
//            wrapper.eq("username", key).or().eq("operation", key);
//        }
        wrapper.orderBy("create_date", false);


        page = sysLogService.selectPage(page,wrapper);

        return R.ok().put("page", page);

    }
}

