package com.iods.iods_backend.validate.mapper;

import com.iods.iods_backend.validate.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ValidateMapper {
    List<UserEntity> queryUser(Map param);

    List<UserEntity> repeateTest(Map param);

    List<UserEntity> queryUserByPhone(Map param);

    List<UserEntity> queryAllUser();

    void insertUser(UserEntity userEntity);

    void editUser(Map map);
    void deleteUser(String userid);
}
