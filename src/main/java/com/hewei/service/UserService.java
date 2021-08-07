package com.hewei.service;


import com.hewei.entity.SysUser;

/**
 * @author HeWei
 * @Date: 2021/08/05/11:49
 * @Description:
 */
public interface UserService {

    /**
     * 新增用户
     * @param user
     * @return
     */
    int add(SysUser user);

    /**
     * 多线程批量新增
     * @return
     */
    int threadAdd();

}
