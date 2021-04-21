package com.iods.iods_backend.validate.service;

import com.iods.iods_backend.validate.entity.UserEntity;
import com.iods.iods_backend.validate.mapper.ValidateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ValidateService {
    @Autowired
    ValidateMapper validateMapper;


    public List<UserEntity> queryUser(Map param) {
        return validateMapper.queryUser(param);
    }

    public List<UserEntity> repeateTest(Map param) {
        return validateMapper.repeateTest(param);
    }

    public List<UserEntity> queryUserByPhone(Map param) {
        return validateMapper.queryUserByPhone(param);
    }

    public void insertUser(UserEntity userEntity) {
        validateMapper.insertUser(userEntity);
    }
}
