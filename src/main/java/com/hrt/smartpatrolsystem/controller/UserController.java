package com.hrt.smartpatrolsystem.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hrt.smartpatrolsystem.common.vos.ResponseResult;
import com.hrt.smartpatrolsystem.constants.HttpCodeEnum;
import com.hrt.smartpatrolsystem.service.IUserService;
import com.hrt.smartpatrolsystem.user.dtos.UserDTO;
import com.hrt.smartpatrolsystem.user.dtos.UserPageDTO;
import com.hrt.smartpatrolsystem.user.pojos.User;
import com.hrt.smartpatrolsystem.user.vos.UserVO;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import java.util.Date;

/**
 * ClassName: UserController
 * Package: com.hrt.smartpatrolsystem.controller
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/3/28 - 17:13
 * @Version: v1.0
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public ResponseResult<UserVO> getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteUserById(@PathVariable Integer id){
        return userService.deleteUserById(id);
    }

    @PostMapping
    public ResponseResult addUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseResult updateUser(@PathVariable Integer id,@RequestBody UserDTO userDTO){
        return userService.updateUser(id,userDTO);
    }

    @PutMapping("/{id}/status")
    public ResponseResult updateUserStatus(@PathVariable Integer id,@RequestBody UserDTO userDTO){
        return userService.updateUser(id,userDTO);
    }


    @GetMapping
    public ResponseResult getUserList(@RequestBody UserPageDTO userPageDTO){
            return userService.getUserList(userPageDTO);
    }

}
