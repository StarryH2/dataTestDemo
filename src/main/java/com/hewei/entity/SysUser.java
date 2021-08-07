package com.hewei.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author HeWei
 * @Date: 2021/08/05/11:40
 * @Description:
 */
@Data
public class SysUser {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String nickName;

    private String idCard;

    private String userName;

    private String password;

    private String phone;

    private String email;

    private String address;

    private Long createBy;

    private String createTime;

    private Long updateBy;

    private String updateTime;


}
