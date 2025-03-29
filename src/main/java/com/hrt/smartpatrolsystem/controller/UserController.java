package com.hrt.smartpatrolsystem.controller;

import com.hrt.smartpatrolsystem.common.vos.ResponseResult;
import com.hrt.smartpatrolsystem.constants.HttpCodeEnum;
import com.hrt.smartpatrolsystem.service.IUserService;
import com.hrt.smartpatrolsystem.user.pojos.User;
import com.hrt.smartpatrolsystem.user.vos.UserVO;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;

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
        User user = userService.getById(id);
        if (user == null){
            return ResponseResult.errorResult(HttpCodeEnum.ERROR);
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO,UserVO.class);
        return ResponseResult.okResult(userVO);
    }

    @DeleteMapping("{id}")
    public ResponseResult deleteUserById(@PathVariable Integer id){
        boolean b = userService.removeById(id);
        if (b){
            return ResponseResult.okResult(null);
        }
        return ResponseResult.errorResult(HttpCodeEnum.ERROR);
    }

}
