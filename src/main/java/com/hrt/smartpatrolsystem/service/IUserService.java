package com.hrt.smartpatrolsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hrt.smartpatrolsystem.common.vos.ResponseResult;
import com.hrt.smartpatrolsystem.user.dtos.UserDTO;
import com.hrt.smartpatrolsystem.user.pojos.User;
import com.hrt.smartpatrolsystem.user.vos.UserVO;

/**
 * ClassName: UserService
 * Package: com.hrt.smartpatrolsystem.service
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/3/29 - 18:02
 * @Version: v1.0
 */
public interface IUserService extends IService<User> {
    /**
     * 根据id查询用户
     * @param id
     */
    ResponseResult<UserVO> getUserById(Integer id);

    /**
     * 根据id删除用户
     * @param id
     */
    ResponseResult deleteUserById(Integer id);

    /**
     * 添加用户
     * @param userDTO
     */
    ResponseResult addUser(UserDTO userDTO);

    /**
     * 更新用户
     * @param id
     * @param userDTO
     */
    ResponseResult updateUser(Integer id, UserDTO userDTO);
}
