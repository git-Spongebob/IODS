package com.iods.iods_backend.menumanage.controller;


import com.iods.iods_backend.menumanage.entity.Menu;
import com.iods.iods_backend.menumanage.entity.MenuEntity;
import com.iods.iods_backend.menumanage.entity.SysMenu;
import com.iods.iods_backend.menumanage.service.MenuService;
import com.iods.iods_backend.upload.entity.ReturnMessage;
import com.iods.iods_backend.validate.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/menumanage")
/**
 * @author wangzitong
 * 菜单管理
 */
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/queryAllMenu")
    public List<MenuEntity> queryUserByPhone() {
        return menuService.queryAllUser();
    }

    /**
     * 编辑用户信息（管理员修改）
     * @param map
     * @return
     */
    @PostMapping(value="/editUser")
    public ReturnMessage editUser(@RequestBody Map map){
        try {
            menuService.editUser(map);
            return new ReturnMessage().success();
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }
    @PostMapping("/insertUser")
    public String insertUser(@RequestBody Map map) {
        menuService.insertUser(map);
        return "success";
    }





}