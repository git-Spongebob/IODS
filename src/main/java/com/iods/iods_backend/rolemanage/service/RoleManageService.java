package com.iods.iods_backend.rolemanage.service;

import com.iods.iods_backend.rolemanage.entity.RoleManageEntity;
import com.iods.iods_backend.rolemanage.mapper.RoleManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleManageService {
    @Autowired
    RoleManageMapper roleManageMapper;


    public List<RoleManageEntity> queryRole(Map param) {
        return roleManageMapper.queryRole(param);
    }

    public List<RoleManageEntity> queryRoleByRoleName(Map param) { return roleManageMapper.queryRoleByRoleName(param); }
    public List<RoleManageEntity> queryAllRole() {
        return roleManageMapper.queryAllRole();
    }
    public void editRole(Map map) {
        roleManageMapper.editRole(map);
    }
    public void deleteRole(String roleId){ roleManageMapper.deleteRole(roleId);
    }

    public void addRole(RoleManageEntity roleManageEntity) {
        roleManageMapper.addRole(roleManageEntity);
    }
}
