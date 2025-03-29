package com.hrt.smartpatrolsystem.user.vos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName: UserVO
 * Package: com.hrt.smartpatrolsystem.user.vos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/3/29 - 17:56
 * @Version: v1.0
 */
@Data
public class UserVO {
    @JsonProperty("id")
    private String id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("status")
    private Short status;

    @JsonProperty("role")
    private Short role;

    @JsonProperty("created_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @JsonProperty("updated_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;
}
