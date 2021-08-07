package com.hewei.service.impl;


import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hewei.entity.SysUser;
import com.hewei.mapper.UserMapper;
import com.hewei.service.UserService;
import com.hewei.utils.IdCardUtil;
import com.hewei.utils.PinYinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import utils.RandomPersonInfoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author HeWei
 * @Date: 2021/08/05/11:50
 * @Description:
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements UserService {


    @Override
    public int add(SysUser user) {
        return 0;
    }

    Long begin;

    @Autowired
    ThreadPoolExecutor tExecutor;

    @Override
    public int threadAdd() {
        begin = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            //开启一千个线程
            tExecutor.execute(new DemoRunnable());
        }
        //线程池任务结束立即关闭线程池
        tExecutor.shutdown();
        System.out.println(tExecutor.getMaximumPoolSize());
        // 结束时间
        Long end = System.currentTimeMillis();
        // 耗時
        System.out.println("1000万条数据插入花费时间 : " + (end - begin) / 1000);
        System.out.println(end);
        System.out.println(begin);
        return 0;
    }

    @Autowired
    private TransactionDefinition t;

    @Autowired
    private DataSourceTransactionManager manager;

    @Autowired
    private UserMapper userMapper;

    private class DemoRunnable implements Runnable {

        @Override
        public void run() {
            TransactionStatus status = null;
            List<SysUser> sysUserList = new ArrayList<>();
            SysUser user = null;
            try {
                //事务状态，每10000条数据批量插入
                status = manager.getTransaction(t);
                for (int j = 0; j < 1000; j++) {
                    user = new SysUser();
                    String nickName = RandomPersonInfoUtil.getRandomChineseName();
                    user.setNickName(nickName);//姓名
                    user.setIdCard(IdCardUtil.getIdCard());
                    user.setUserName(PinYinUtil.getPingYin(nickName));//登录账号
                    user.setPassword("123456");//登录账号
                    user.setPhone(RandomPersonInfoUtil.getRandomTelephoneNumber());//手机号
                    user.setEmail(RandomPersonInfoUtil.getEmail());//邮箱
                    user.setAddress(RandomPersonInfoUtil.getRandomLocation());//地址
                    user.setCreateBy(0L);
                    user.setCreateTime(DateUtil.now());
                    sysUserList.add(user);
                }
                userMapper.insertUsers(sysUserList);
                //提交事务
                manager.commit(status);

            } catch (Exception e) {
                e.printStackTrace();
                if (status == null) {
                    //失败回滚
                    manager.rollback(status);
                }
            }

        }

    }
}
