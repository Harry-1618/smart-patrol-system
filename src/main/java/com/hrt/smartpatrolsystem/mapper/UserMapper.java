package com.hrt.smartpatrolsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hrt.smartpatrolsystem.user.pojos.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * ClassName: UserMapper
 * Package: com.hrt.smartpatrolsystem.mapper
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/3/29 - 18:05
 * @Version: v1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
