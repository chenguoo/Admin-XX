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

    private SysDeptMapper sysDeptDao;

    public SysDeptServiceImpl(SysDeptMapper sysDeptDao) {
        this.sysDeptDao = sysDeptDao;
    }

    @Override
    public SysDept selectById(Long deptId) {

        return sysDeptDao.selectById(deptId);
    }

    @Override
    public List<SysDeptVo> querySysDeptVoList(SysDeptVo sysDeptVo) {

        return sysDeptDao.querySysDeptVoList(sysDeptVo);
    }


}
