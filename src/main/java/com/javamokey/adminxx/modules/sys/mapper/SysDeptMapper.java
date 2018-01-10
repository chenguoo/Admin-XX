package com.javamokey.adminxx.modules.sys.mapper;

import com.javamokey.adminxx.modules.sys.entity.SysDept;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.javamokey.adminxx.modules.sys.entity.vo.SysDeptVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 部门管理 Mapper 接口
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {

    SysDeptVo selectSysDeptVoById(@Param("deptId") Long deptId);

    List<SysDeptVo> querySysDeptVoList(SysDeptVo sysDeptVo);

}
