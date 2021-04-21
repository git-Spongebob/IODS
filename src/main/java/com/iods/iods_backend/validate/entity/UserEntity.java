package com.iods.iods_backend.validate.entity;

import lombok.Data;

/**
 * 用户实体类
 *
 * @author xurongbin
 * @date 2020/3/17
 */
@Data
public class UserEntity {
    /**
     * 用户名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String phone;
}
