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
     * 用户英文名
     */
    private String ename;
    /**
     * 用户中文名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private String sex;
    /**
     * 所属组织机构
     */
    private String department;
    /**
     * 角色
     */
    private String role;
    /**
     * 用户id
     */
    private String userid;
}
