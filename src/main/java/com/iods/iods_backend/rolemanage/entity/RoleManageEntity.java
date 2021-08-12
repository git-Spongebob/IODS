package com.iods.iods_backend.rolemanage.entity;

import lombok.Data;

@Data
public class RoleManageEntity {
    /**
     * id
     */
    private String roleId;
    /**
     * 名
     */
    private String roleName;
    /**
     * 描述
     */
    private String roleDescription;
    /**
     * 权限
     */
    private String rolePower;
    /**
     * 状态
     */
    private String roleState;
}