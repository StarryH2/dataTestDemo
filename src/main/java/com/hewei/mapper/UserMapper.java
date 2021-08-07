package com.hewei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hewei.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HeWei
 * @Date: 2021/08/05/11:53
 * @Description:
 */
public interface UserMapper extends BaseMapper<SysUser> {

    /**
     * 新增选手
     *
     * @param user
     * @return
     */
    int insertUser(SysUser user);

    /**
     * 批量插入
     * @param userList
     */
    void insertUsers(@Param("") List<SysUser> userList);
}
