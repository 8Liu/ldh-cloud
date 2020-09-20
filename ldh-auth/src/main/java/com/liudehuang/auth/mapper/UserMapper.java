package com.liudehuang.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liudehuang.common.entity.system.SystemUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<SystemUser> {
    SystemUser findByName(String username);
}