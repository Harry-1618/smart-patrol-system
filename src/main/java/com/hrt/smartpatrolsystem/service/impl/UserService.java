package com.hrt.smartpatrolsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hrt.smartpatrolsystem.mapper.UserMapper;
import com.hrt.smartpatrolsystem.service.IUserService;
import com.hrt.smartpatrolsystem.user.pojos.User;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserService
 * Package: com.hrt.smartpatrolsystem.service.impl
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/3/29 - 18:04
 * @Version: v1.0
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
}
