package com.javamokey.adminxx.modules.sys.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.javamokey.adminxx.modules.sys.entity.SysRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.javamokey.adminxx.modules.sys.entity.vo.SysRoleVo;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * <p>
     * 查询 : 角色列表，分页显示
     * </p>
     *
     * @param page 翻页对象，可以作为 xml 参数直接使用，传递参数 Page 即自动分页
     * @return
     */
    List<SysRoleVo> querySysRoleVoPage(Pagination page);

    SysRoleVo querySysRoleVoById(Long roleId);

    void deleteBatch(Long[] roleIds);

    void save(SysRoleVo role);
}
