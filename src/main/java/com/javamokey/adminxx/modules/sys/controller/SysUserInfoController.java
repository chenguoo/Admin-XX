package com.javamokey.adminxx.modules.sys.controller;


import com.javamokey.adminxx.modules.sys.entity.SysUserInfo;
import com.javamokey.adminxx.modules.sys.mapper.SysUserInfoMapper;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Cheney
 * @since 2017-12-25
 */
@Controller
@RequestMapping("/sys/sysUserInfo")
public class SysUserInfoController {

    private final SysUserInfoMapper sysUserInfoMapper;

    public SysUserInfoController(SysUserInfoMapper sysUserInfoMapper){
        this.sysUserInfoMapper = sysUserInfoMapper;
    }

    @ResponseBody
    @RequestMapping("test")
    public SysUserInfo test(){

        Map<String, Object> params = new HashMap<>();
        params.put("user_id",784972358981328902L);
        List<SysUserInfo> sysUserInfos = sysUserInfoMapper.selectByMap(params);

        return sysUserInfos.get(0);

    }

}

