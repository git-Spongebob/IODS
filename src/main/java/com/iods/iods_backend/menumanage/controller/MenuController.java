package com.iods.iods_backend.menumanage.controller;


import com.iods.iods_backend.menumanage.entity.MenuEntity;
import com.iods.iods_backend.menumanage.service.MenuService;
import com.iods.iods_backend.upload.entity.ReturnMessage;
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
    /**
     * 新建菜单
     * @param
     * @return
     */
    @PostMapping("/addMenu")
    public String addMenu(@RequestBody MenuEntity menuEntity) {
        menuService.addMenu(menuEntity);
        return "success";
    }


    /**
     * 删除菜单
     * @param id
     * @return
     */
    @DeleteMapping(value="/deleteMenu/{id}")
    public ReturnMessage deleteUser(@PathVariable("id") int id){
        try {
            menuService.deleteMenu(id);
            return new ReturnMessage().success();
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }



}
