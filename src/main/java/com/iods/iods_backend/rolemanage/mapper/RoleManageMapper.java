package com.iods.iods_backend.rolemanage.mapper;

import com.iods.iods_backend.rolemanage.entity.RoleManageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface RoleManageMapper {
    List<RoleManageEntity> queryRole(Map param);

    List<RoleManageEntity> queryRoleByRoleName(Map param);

    List<RoleManageEntity> queryAllRole();

    void insertRole(RoleManageEntity roleManageEntity);

    void editRole(Map map);
    void deleteRole(String roleId);
}
