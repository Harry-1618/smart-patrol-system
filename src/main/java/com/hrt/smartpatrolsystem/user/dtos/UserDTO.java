package com.hrt.smartpatrolsystem.user.dtos;

import lombok.Data;

/**
 * ClassName: UserDTO
 * Package: com.hrt.smartpatrolsystem.user.dtos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/3/30 - 12:29
 * @Version: v1.0
 */
@Data
public class UserDTO {
    private String username;
    private String name;
    private String password;
    private String role;
    private String phone;
    private String email;
}
