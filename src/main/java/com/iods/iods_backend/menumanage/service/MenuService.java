package com.iods.iods_backend.menumanage.service;

import com.iods.iods_backend.menumanage.entity.MenuEntity;
import com.iods.iods_backend.menumanage.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MenuService {

    @Autowired
     MenuMapper menuMapper;


    public List<MenuEntity> queryAllUser() {
        return menuMapper.queryAllUser();
    }

    public void editUser(Map map) {
        menuMapper.editUser(map);
    }
    public void insertUser(Map map) {
        menuMapper.insertUser(map);
    }
    public void addMenu(MenuEntity menuEntity) {
        menuMapper.addMenu(menuEntity);
    }
    public void deleteMenu(int id) {
        menuMapper.deleteMenu(id);
    }

}
