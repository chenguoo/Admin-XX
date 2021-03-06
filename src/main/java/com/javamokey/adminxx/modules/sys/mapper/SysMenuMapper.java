package com.javamokey.adminxx.modules.sys.mapper;

import com.javamokey.adminxx.modules.sys.entity.SysMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.javamokey.adminxx.modules.sys.entity.vo.SysMenuVo;

import java.util.List;

/**
 * <p>
 * 菜单管理 Mapper 接口
 * </p>
 *
 * @author Cheney
 * @since 2017-12-26
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    List<SysMenuVo> queryListParentId(Long parentId);

    /**
     * 查询菜单列表
     * @return
     */
    List<SysMenuVo> queryList();

}
