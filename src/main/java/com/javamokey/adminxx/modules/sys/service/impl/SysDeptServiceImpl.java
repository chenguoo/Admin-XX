package com.javamokey.adminxx.modules.sys.service.impl;

import com.javamokey.adminxx.modules.sys.entity.SysDept;
import com.javamokey.adminxx.modules.sys.entity.vo.SysDeptVo;
import com.javamokey.adminxx.modules.sys.mapper.SysDeptMapper;
import com.javamokey.adminxx.modules.sys.service.SysDeptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 部门管理 服务实现类
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    private SysDeptMapper sysDeptMapper;

    public SysDeptServiceImpl(SysDeptMapper sysDeptMapper) {
        this.sysDeptMapper = sysDeptMapper;
    }

    @Override
    public SysDept selectById(Long deptId) {

        return sysDeptMapper.selectById(deptId);
    }

    @Override
    public SysDeptVo selectSysDeptVoById(Long deptId) {
        
        return sysDeptMapper.selectSysDeptVoById(deptId);
    }

    @Override
    public List<SysDeptVo> querySysDeptVoList(SysDeptVo sysDeptVo) {
        return sysDeptMapper.querySysDeptVoList(sysDeptVo);
    }


}
