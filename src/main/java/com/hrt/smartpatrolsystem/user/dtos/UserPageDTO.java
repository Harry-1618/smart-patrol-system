package com.hrt.smartpatrolsystem.user.dtos;

import com.hrt.smartpatrolsystem.common.dtos.PageRequestDto;
import lombok.Data;

/**
 * ClassName: UserPageDTO
 * Package: com.hrt.smartpatrolsystem.user.dtos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/1 - 15:18
 * @Version: v1.0
 */
@Data
public class UserPageDTO extends PageRequestDto {
    private String username;
    private String name;
    private Short role;
    private Short status;
    private String phone;
    private String email;
}
