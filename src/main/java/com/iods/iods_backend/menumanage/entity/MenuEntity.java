package com.iods.iods_backend.menumanage.entity;


import lombok.Data;

/**
 * 用户实体类
 *
 * @author wangzitong
 * @date 2021/8/12
 */
@Data
public class MenuEntity {

    /**
     * 用户id
     */
    private int id;
    /**
     * 用户子母id
     */
    private String parent_id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 菜单URL
     */
    private String path;
    /**
     * 权限编码
     */

    private String perms;

    /**
     * 菜单组件
     */
    private String component;
    /**
     * 类型
     */
    private int type;
    /**
     * 图标
     */
    private String icon;
    /**
     * 状态
     */
    private int statu;
    /**
     * 操作
     */
    private int orderNum;


}
