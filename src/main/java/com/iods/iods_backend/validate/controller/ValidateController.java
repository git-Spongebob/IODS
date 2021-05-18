package com.iods.iods_backend.validate.controller;

import com.iods.iods_backend.validate.entity.UserEntity;
import com.iods.iods_backend.validate.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/validate")
/**
 * @author xurongbin
 * 登录验证
 */
public class ValidateController {
    @Autowired
    private ValidateService validateService;

    @GetMapping("/queryUser")
    public List<UserEntity> queryUser(@RequestParam Map param) {
        return validateService.queryUser(param);
    }

    @GetMapping("/repeateTest")
    public List<UserEntity> repeateTest(@RequestParam Map param) {
        return validateService.repeateTest(param);
    }

    @GetMapping("/queryUserByPhone")
    public List<UserEntity> queryUserByPhone(@RequestParam Map param) {
        return validateService.queryUserByPhone(param);
    }

    @PostMapping("/insertUser")
    public String insertUser(@RequestBody UserEntity userEntity) {
        validateService.insertUser(userEntity);
        return "success";
    }


}
