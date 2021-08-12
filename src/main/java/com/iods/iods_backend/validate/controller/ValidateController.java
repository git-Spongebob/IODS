package com.iods.iods_backend.validate.controller;

import com.iods.iods_backend.upload.entity.ReturnMessage;
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
    @GetMapping("/queryAllUser")
    public List<UserEntity> queryUserByPhone() {
        return validateService.queryAllUser();
    }
    @GetMapping("/queryLikeUser")
    public List<UserEntity> queryLikeUser(@RequestParam Map param) {
        return validateService.queryLikeUser(param);
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserEntity userEntity) {
        validateService.addUser(userEntity);
        return "success";
    }
    /**
     * 用户信息修改（管理员修改）
     * @param map
     * @return
     */
    @PostMapping(value="/editUser")
    public ReturnMessage editUser(@RequestBody Map map){
        try {
            validateService.editUser(map);
            return new ReturnMessage().success();
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }
    /**
     * 删除用户（管理员删除）
     * @param userid
     * @return
     */
    @DeleteMapping(value="/deleteUser/{userid}")
    public ReturnMessage deleteUser(@PathVariable("userid") String userid){
        try {
            validateService.deleteUser(userid);
            return new ReturnMessage().success();
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }


}
