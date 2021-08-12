package com.iods.iods_backend.rolemanage.controller;

import com.iods.iods_backend.rolemanage.entity.RoleManageEntity;
import com.iods.iods_backend.rolemanage.service.RoleManageService;
import com.iods.iods_backend.upload.entity.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rolemanage")
public class RoleManageController {
    @Autowired
    private RoleManageService roleManageService;

    @GetMapping("/queryRole")
    public List<RoleManageEntity> queryRole(@RequestParam Map param) {
        return roleManageService.queryRole(param);
    }

    @GetMapping("/queryRoleByRoleName")
    public List<RoleManageEntity> queryRoleByRoleName(@RequestParam Map param) {
        return roleManageService.queryRoleByRoleName(param);
    }
    @GetMapping("/queryAllRole")
    public List<RoleManageEntity> queryAllRole() {
        return roleManageService.queryAllRole();
    }

    @PostMapping("/insertRole")
    public String insertRole(@RequestBody RoleManageEntity roleManageEntity) {
        roleManageService.insertRole(roleManageEntity);
        return "success";
    }
    /**
     * 角色信息修改（管理员修改）
     * @param map
     * @return
     */
    @PostMapping(value="/editRole")
    public ReturnMessage editRole(@RequestBody Map map){
        try {
            roleManageService.editRole(map);
            return new ReturnMessage().success();
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }
    /**
     * 删除角色（管理员删除）
     * @param roleId
     * @return
     */
    @DeleteMapping(value="/deleteRole/{roleId}")
    public ReturnMessage deleteRole(@PathVariable("roleId") String roleId){
        try {
            roleManageService.deleteRole(roleId);
            return new ReturnMessage().success();
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }

}
