package com.javamokey.adminxx.modules.job.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.javamokey.adminxx.common.util.PageUtils;
import com.javamokey.adminxx.common.util.R;
import com.javamokey.adminxx.common.util.StringUtil;
import com.javamokey.adminxx.modules.job.entity.ScheduleJob;
import com.javamokey.adminxx.modules.job.service.ScheduleJobService;
import com.javamokey.adminxx.modules.sys.entity.SysConfig;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 定时任务 前端控制器
 * </p>
 *
 * @author Cheney123
 * @since 2018-01-14
 */
@RestController
@RequestMapping("/sys/schedule")
public class ScheduleJobController {
    private ScheduleJobService scheduleJobService;

    public ScheduleJobController(ScheduleJobService scheduleJobService) {
        this.scheduleJobService = scheduleJobService;
    }



    /**
     * 定时任务列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:schedule:list")
    public R list(@RequestParam Map<String, String> params){
        //查询列表数据
        Page<ScheduleJob> page = new Page<>(Integer.parseInt(params.get("current")), Integer.parseInt(params.get("size")));

        //查询条件
        EntityWrapper<ScheduleJob> wrapper = new EntityWrapper<>();
        wrapper.like(StringUtil.isNotEmpty(params.get("beanName")), "bean_name", params.get("beanName"));

        page = scheduleJobService.selectPage(page, wrapper);
        return R.ok().put("page", page);
    }
}

