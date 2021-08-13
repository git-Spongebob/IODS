package com.iods.iods_backend.menumanage.mapper;


import com.iods.iods_backend.menumanage.entity.Menu;
import com.iods.iods_backend.menumanage.entity.MenuEntity;
import com.iods.iods_backend.menumanage.entity.SysMenu;
import com.iods.iods_backend.validate.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MenuMapper {


    List<MenuEntity> queryAllUser();
    void editUser(Map map);
    void insertUser(Map map);
}
