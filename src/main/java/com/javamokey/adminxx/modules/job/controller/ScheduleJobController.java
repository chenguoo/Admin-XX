package com.javamokey.adminxx.modules.job.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.javamokey.adminxx.common.annotation.SysLogAnnotation;
import com.javamokey.adminxx.common.util.PageUtils;
import com.javamokey.adminxx.common.util.R;
import com.javamokey.adminxx.common.util.StringUtil;
import com.javamokey.adminxx.common.validator.ValidatorUtils;
import com.javamokey.adminxx.modules.job.entity.ScheduleJob;
import com.javamokey.adminxx.modules.job.service.ScheduleJobService;
import com.javamokey.adminxx.modules.sys.entity.SysConfig;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
    private Logger logger = LoggerFactory.getLogger(getClass());

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

    /**
     * 定时任务信息
     */
    @RequestMapping("/info/{jobId}")
    @RequiresPermissions("sys:schedule:info")
    public R info(@PathVariable("jobId") Long jobId){
        ScheduleJob schedule = scheduleJobService.selectById(jobId);

        return R.ok().put("schedule", schedule);
    }

    /**
     * 保存定时任务
     */
    @SysLogAnnotation("保存定时任务")
    @RequestMapping("/save")
    @RequiresPermissions("sys:schedule:save")
    public R save(@RequestBody ScheduleJob scheduleJob){
        ValidatorUtils.validateEntity(scheduleJob);

        scheduleJobService.insert(scheduleJob);

        return R.ok();
    }

    /**
     * 修改定时任务
     */
    @SysLogAnnotation("修改定时任务")
    @RequestMapping("/update")
    @RequiresPermissions("sys:schedule:update")
    public R update(@RequestBody ScheduleJob scheduleJob){
        ValidatorUtils.validateEntity(scheduleJob);

        scheduleJobService.updateById(scheduleJob);

        return R.ok();
    }

    /**
     * 删除定时任务
     */
    @SysLogAnnotation("删除定时任务")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:schedule:delete")
    public R delete(@RequestBody Long[] jobIds){
        scheduleJobService.deleteBatch(jobIds);

        return R.ok();
    }

    /**
     * 暂停定时任务
     */
    @SysLogAnnotation("暂停定时任务")
    @RequestMapping("/pause")
    @RequiresPermissions("sys:schedule:pause")
    public R pause(@RequestBody Long[] jobIds){
        scheduleJobService.pause(jobIds);

        return R.ok();
    }

    /**
     * 恢复定时任务
     */
    @SysLogAnnotation("恢复定时任务")
    @RequestMapping("/resume")
    @RequiresPermissions("sys:schedule:resume")
    public R resume(@RequestBody Long[] jobIds){
        scheduleJobService.resume(jobIds);

        return R.ok();
    }
    /**
     * 立即执行任务
     */
    @SysLogAnnotation("立即执行任务")
    @RequestMapping("/run")
    @RequiresPermissions("sys:schedule:run")
    public R run(@RequestBody Long[] jobIds){
        scheduleJobService.run(jobIds);

        return R.ok();
    }
}

