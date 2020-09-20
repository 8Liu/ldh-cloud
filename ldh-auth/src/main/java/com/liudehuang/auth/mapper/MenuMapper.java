package com.liudehuang.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liudehuang.common.entity.system.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> findUserPermissions(String username);
}