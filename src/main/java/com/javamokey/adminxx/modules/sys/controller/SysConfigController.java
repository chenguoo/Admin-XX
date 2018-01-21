package com.javamokey.adminxx.modules.sys.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.javamokey.adminxx.common.annotation.SysLogAnnotation;
import com.javamokey.adminxx.common.util.R;
import com.javamokey.adminxx.common.util.StringUtil;
import com.javamokey.adminxx.common.validator.ValidatorUtils;
import com.javamokey.adminxx.modules.sys.entity.SysConfig;
import com.javamokey.adminxx.modules.sys.service.SysConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * <p>
 * 系统配置信息表 前端控制器
 * </p>
 *
 * @author Cheney
 * @since 2018-01-14
 */
@RestController
@RequestMapping("/sys/config")
public class SysConfigController {

    private SysConfigService sysConfigService;

    public SysConfigController(SysConfigService sysConfigService) {
        this.sysConfigService = sysConfigService;
    }


    /**
     * 所有配置列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:config:list")
    public R list(@RequestParam Map<String, String> params) {

        //查询列表数据
        Page<SysConfig> page = new Page<>(Integer.parseInt(params.get("current")), Integer.parseInt(params.get("size")));

        //查询条件
        EntityWrapper<SysConfig> wrapper = new EntityWrapper<>();
        wrapper.like(StringUtil.isNotEmpty(params.get("configKey")), "config_key", params.get("configKey"));

        page = sysConfigService.selectPage(page, wrapper);
        return R.ok().put("page", page);
    }


    /**
     * 配置信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:config:info")
    public R info(@PathVariable("id") Long id) {
        SysConfig config = sysConfigService.selectById(id);

        return R.ok().put("config", config);
    }

    /**
     * 保存配置
     */
    @SysLogAnnotation("保存配置")
    @RequestMapping("/save")
    @RequiresPermissions("sys:config:save")
    public R save(@RequestBody SysConfig config) {
        ValidatorUtils.validateEntity(config);

        sysConfigService.insert(config);

        return R.ok();
    }

    /**
     * 修改配置
     */
    @SysLogAnnotation("修改配置")
    @RequestMapping("/update")
    @RequiresPermissions("sys:config:update")
    public R update(@RequestBody SysConfig config) {
        ValidatorUtils.validateEntity(config);

        sysConfigService.updateById(config);

        return R.ok();
    }

    /**
     * 删除配置
     */
    @SysLogAnnotation("删除配置")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:config:delete")
    public R delete(@RequestBody Long[] ids) {

        ArrayList<Long> idLists = new ArrayList<>(Arrays.asList(ids));

        sysConfigService.deleteBatchIds(idLists);
        return R.ok();
    }
}

