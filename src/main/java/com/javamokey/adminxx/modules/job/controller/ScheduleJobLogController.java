package com.javamokey.adminxx.modules.job.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.javamokey.adminxx.common.util.PageUtils;
import com.javamokey.adminxx.common.util.R;
import com.javamokey.adminxx.common.util.StringUtil;
import com.javamokey.adminxx.modules.job.entity.ScheduleJob;
import com.javamokey.adminxx.modules.job.entity.ScheduleJobLog;
import com.javamokey.adminxx.modules.job.service.ScheduleJobLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 定时任务日志 前端控制器
 * </p>
 *
 * @author Cheney
 * @since 2018-01-14
 */
@RestController
@RequestMapping("/sys/scheduleLog")
public class ScheduleJobLogController {
    private ScheduleJobLogService scheduleJobLogService;

    public ScheduleJobLogController(ScheduleJobLogService scheduleJobLogService) {
        this.scheduleJobLogService = scheduleJobLogService;
    }

    /**
     * 定时任务日志列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:schedule:log")
    public R list(@RequestParam Map<String, String> params){
        //查询列表数据
        Page<ScheduleJobLog> page = new Page<>(Integer.parseInt(params.get("current")), Integer.parseInt(params.get("size")));

        //查询条件
        EntityWrapper<ScheduleJobLog> wrapper = new EntityWrapper<>();
        wrapper.like(StringUtil.isNotEmpty(params.get("jobId")), "job_id", params.get("jobId"));
        wrapper.orderBy("create_time", false);

        page = scheduleJobLogService.selectPage(page, wrapper);

        return R.ok().put("page", page);
    }

    /**
     * 定时任务日志信息
     */
    @RequestMapping("/info/{logId}")
    public R info(@PathVariable("logId") Long logId){
        ScheduleJobLog log = scheduleJobLogService.selectById(logId);

        return R.ok().put("log", log);
    }


}

