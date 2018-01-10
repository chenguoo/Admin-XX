package com.javamokey.adminxx.modules.sys.service;

import com.javamokey.adminxx.common.util.R;
import com.javamokey.adminxx.modules.sys.entity.SysDept;
import com.baomidou.mybatisplus.service.IService;
import com.javamokey.adminxx.modules.sys.entity.vo.SysDeptVo;

import java.util.List;

/**
 * <p>
 * 部门管理 服务类
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
public interface SysDeptService extends IService<SysDept> {

    SysDept selectById(Long deptId);

    SysDeptVo selectSysDeptVoById(Long deptId);

    List<SysDeptVo> querySysDeptVoList(SysDeptVo sysDeptVo);

}
